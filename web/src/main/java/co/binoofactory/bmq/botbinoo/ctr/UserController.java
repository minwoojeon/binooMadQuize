package co.binoofactory.bmq.botbinoo.ctr;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.binoofactory.bmq.botbinoo.svc.UserService;
import co.binoofactory.bmq.botbinoo.vo.UserVO;
import net.sf.json.JSONArray;

/**
 * @Class Name : UserController
 * @Description : User-pages controller
 * @author botbinoo@naver.com
 * @since 2018.02.28
 * @version 1
 *
 *  Copyright (C) by botbinoo's All right reserved.
 */

@Controller
public class UserController {

	@Autowired(required=false)
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * @Method Name : getUserItemProcess
	 * @Description : processing user DB (회원 정보 수정/삭제/추가 등 거의 모든 작업)
	 * @author botbinoo@naver.com
	 * @since 2018.02.28
	 * @last 2018.02.28
	 * @param
	 *  - url path {proc-value} & {secure-key}.
	 * @return 
	 *  - sql result (json).
	 *  Copyright (C) by botbinoo's All right reserved.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/user/confirm/{value}/{key}", method = RequestMethod.POST)
	public @ResponseBody JSONArray getUserItemProcess ( 
			@PathVariable("value") String value,
			@PathVariable("key") String key,
			@ModelAttribute(value="userVO") @Validated UserVO userVO
		) throws Exception {
		
		logger.info("in user map.");
		// Add url second [key:String(100)] -> is Valid?.
		// mac 주소와 time slice 에 따라 암호화 키를 주고 이것이 발급한 시큐어 키에 있는지 확인. TODO: key confirm
		// 발급한 시큐어키에 없거나 키의 세션이 끝났다면 이 메소드를 실행조차 하지 않는다.

		// 발급한 시큐어키가 있고, 세션이 만료되지 않았다면 아래를 실행한다.
		JSONArray result = new JSONArray();
		
		/* sign-in : 로그인 */
		if("sign-in".equals(value)) {
			// Add url first [login] -> confirm id & password.
			// step 1. remove -- & ' inject attack.
			userVO.setUserid((""+userVO.getUserid()).replaceAll("--", ""));
			userVO.setUserid((""+userVO.getUserid()).replaceAll("\'", ""));
			// step 2. id & password empty, sign-in failure.
			if(userVO.getUserid() == null || "".equals(userVO.getUserid())) {
				result.add(0, "f"); 					// 성공실패여부
				result.add(1, "LGN EMPTY ID"); 			// 실패이유
				result.add(2, "아이디를 정확히 입력해주세요.");	// 한글 메시지
				result.add(3, "Please input your id.");	// 영문 메시지
				return result;
			}
			if(userVO.getUserpw() == null || "".equals(userVO.getUserpw())) {
				result.add(0, "f"); 							// 성공실패여부
				result.add(1, "LGN EMPTY PW"); 					// 실패이유
				result.add(2, "비밀번호를 정확히 입력해주세요.");		// 한글 메시지
				result.add(3, "Please input your password.");	// 영문 메시지
				return result;
			}
			// step 3. select id -> it is exist?
			UserVO confirmVO = new UserVO();
			confirmVO.setUserid(userVO.getUserid());
			List<UserVO> userData = userService.selectUserList(confirmVO);
			if(userData.size()==1) {
				// step 3-1. found id.
				// step 4. encrypt password & confirm. TODO: encrypt
				// userVO.getUserpw() 암호화한다.
				if((confirmVO.getUserpw()+"").equals(userVO.getUserpw())) {
					// inner encrypt password equals user password encrypt
					// step 5. create session & update incorrect password count.
					confirmVO.setPwincorrectcnt(0);
					userService.updateUser(confirmVO);
					result.add(0, "s"); 							// 성공실패여부
					result.add(1, "LGN S"); 						// 실패이유
					result.add(2, "로그인 성공");						// 한글 메시지
					result.add(3, "Success.");						// 영문 메시지
				} else {
					// not match password.
					confirmVO.setPwincorrectcnt(confirmVO.getPwincorrectcnt()+1);
					userService.updateUser(confirmVO);
					result.add(0, "f"); 							// 성공실패여부
					result.add(1, "LGN NMATCH PW"); 				// 실패이유
					result.add(2, "비밀번호를 정확히 입력해주세요.");		// 한글 메시지
					result.add(3, "Please input your password.");	// 영문 메시지
					result.add(4, confirmVO.getPwincorrectcnt());	// 비밀번호 틀린횟수.
				}
			} else {
				// step 3-2. not found id.
				result.add(0, "f"); 							// 성공실패여부
				result.add(1, "LGN NFOUND ID"); 				// 실패이유
				result.add(2, "아이디를 정확히 입력해주세요.");			// 한글 메시지
				result.add(3, "Please input your id.");			// 영문 메시지
			}
			
		} else if("sign-up".equals(value)) {
			/* sign-up : 회원가입 */
			// step 1. remove -- & ' inject attack.
			userVO.setUserid((""+userVO.getUserid()).replaceAll("--", "").replaceAll("\'", ""));
			userVO.setUsernick((""+userVO.getUsernick()).replaceAll("--", "").replaceAll("\'", ""));
			// step 2. validation check. TODO : validation offer
			// step 3. insert.
			userService.insertUser(userVO);
			result.add(0, "s"); 							// 성공실패여부
			result.add(1, "JOIN S"); 						// 실패이유
			result.add(2, "가입 성공");						// 한글 메시지
			result.add(3, "Success.");						// 영문 메시지
			
		} else if("sign-edit".equals(value)) {
			/* sign-edit : 회원수정 */
			// step 1. remove -- & ' inject attack.
			userVO.setUserid((""+userVO.getUserid()).replaceAll("--", "").replaceAll("\'", ""));
			userVO.setUsernick((""+userVO.getUsernick()).replaceAll("--", "").replaceAll("\'", ""));
			// step 2. validation check. TODO : validation offer
			// step 3. insert.
			userService.updateUser(userVO);
			result.add(0, "s"); 							// 성공실패여부
			result.add(1, "EDIT S"); 						// 실패이유
			result.add(2, "수정 성공");						// 한글 메시지
			result.add(3, "Success.");						// 영문 메시지
			
		} else if("sign-view".equals(value)) {
			/* sign-view : 회원정보 보기 */
			// step 1. remove -- & ' inject attack.
			userVO.setUserid((""+userVO.getUserid()).replaceAll("--", ""));
			userVO.setUserid((""+userVO.getUserid()).replaceAll("\'", ""));
			// step 2. id & password empty, sign-in failure.
			if(userVO.getUserid() == null || "".equals(userVO.getUserid())) {
				result.add(0, "f"); 					// 성공실패여부
				result.add(1, "LGN EMPTY ID"); 			// 실패이유
				result.add(2, "아이디를 정확히 입력해주세요.");	// 한글 메시지
				result.add(3, "Please input your id.");	// 영문 메시지
				return result;
			}
			if(userVO.getUserpw() == null || "".equals(userVO.getUserpw())) {
				result.add(0, "f"); 							// 성공실패여부
				result.add(1, "LGN EMPTY PW"); 					// 실패이유
				result.add(2, "비밀번호를 정확히 입력해주세요.");		// 한글 메시지
				result.add(3, "Please input your password.");	// 영문 메시지
				return result;
			}
			// step 3. select id -> it is exist?
			UserVO confirmVO = new UserVO();
			confirmVO.setUserid(userVO.getUserid());
			List<UserVO> userData = userService.selectUserList(confirmVO);
			if(userData.size()==1) {
				// step 3-1. found id.
				// step 4. encrypt password & confirm. TODO: encrypt
				// userVO.getUserpw() 암호화한다.
				if((confirmVO.getUserpw()+"").equals(userVO.getUserpw())) {
					// inner encrypt password equals user password encrypt
					// step 5. create session & update incorrect password count.
					confirmVO.setPwincorrectcnt(0);
					userService.updateUser(confirmVO);
					result.add(0, "s"); 							// 성공실패여부
					result.add(1, "VIEW S"); 						// 실패이유
					result.add(2, "로그인 성공");						// 한글 메시지
					result.add(3, "Success.");						// 영문 메시지
					result.add(4, JSONArray.fromObject(confirmVO));	// 보여줄 값
				} else {
					// not match password.
					result.add(0, "f"); 							// 성공실패여부
					result.add(1, "LGN NMATCH PW"); 				// 실패이유
					result.add(2, "비밀번호를 정확히 입력해주세요.");		// 한글 메시지
					result.add(3, "Please input your password.");	// 영문 메시지
				}
			} else {
				// step 3-2. not found id.
				result.add(0, "f"); 							// 성공실패여부
				result.add(1, "LGN NFOUND ID"); 				// 실패이유
				result.add(2, "아이디를 정확히 입력해주세요.");			// 한글 메시지
				result.add(3, "Please input your id.");			// 영문 메시지
			}
			
		} else if("sign-out".equals(value)) {
			/* sign-out : 회원탈퇴 */
			// step 1. remove -- & ' inject attack.
			userVO.setUserid((""+userVO.getUserid()).replaceAll("--", ""));
			userVO.setUserid((""+userVO.getUserid()).replaceAll("\'", ""));
			// step 2. id & password empty, sign-in failure.
			if(userVO.getUserid() == null || "".equals(userVO.getUserid())) {
				result.add(0, "f"); 					// 성공실패여부
				result.add(1, "LGN EMPTY ID"); 			// 실패이유
				result.add(2, "아이디를 정확히 입력해주세요.");	// 한글 메시지
				result.add(3, "Please input your id.");	// 영문 메시지
				return result;
			}
			if(userVO.getUserpw() == null || "".equals(userVO.getUserpw())) {
				result.add(0, "f"); 							// 성공실패여부
				result.add(1, "LGN EMPTY PW"); 					// 실패이유
				result.add(2, "비밀번호를 정확히 입력해주세요.");		// 한글 메시지
				result.add(3, "Please input your password.");	// 영문 메시지
				return result;
			}
			// step 3. select id -> it is exist?
			UserVO confirmVO = new UserVO();
			confirmVO.setUserid(userVO.getUserid());
			List<UserVO> userData = userService.selectUserList(confirmVO);
			if(userData.size()==1) {
				// step 3-1. found id.
				// step 4. encrypt password & confirm. TODO: encrypt
				// userVO.getUserpw() 암호화한다.
				if((confirmVO.getUserpw()+"").equals(userVO.getUserpw())) {
					// inner encrypt password equals user password encrypt
					// step 5. create session & update incorrect password count.
					confirmVO.setPwincorrectcnt(0);
					userService.deleteUser(confirmVO);
					result.add(0, "s"); 							// 성공실패여부
					result.add(1, "OUT S"); 						// 실패이유
					result.add(2, "탈퇴 성공");						// 한글 메시지
					result.add(3, "Success.");						// 영문 메시지
				} else {
					// not match password.
					result.add(0, "f"); 							// 성공실패여부
					result.add(1, "LGN NMATCH PW"); 				// 실패이유
					result.add(2, "비밀번호를 정확히 입력해주세요.");		// 한글 메시지
					result.add(3, "Please input your password.");	// 영문 메시지
				}
			} else {
				// step 3-2. not found id.
				result.add(0, "f"); 							// 성공실패여부
				result.add(1, "LGN NFOUND ID"); 				// 실패이유
				result.add(2, "아이디를 정확히 입력해주세요.");			// 한글 메시지
				result.add(3, "Please input your id.");			// 영문 메시지
			}
			
		}

		return result;
	}
}
