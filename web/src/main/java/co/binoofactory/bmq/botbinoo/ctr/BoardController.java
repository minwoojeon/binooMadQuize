package co.binoofactory.bmq.botbinoo.ctr;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.binoofactory.bmq.botbinoo.svc.FreeBoardService;
import co.binoofactory.bmq.botbinoo.svc.MenuService;
import co.binoofactory.bmq.botbinoo.svc.UserService;
import co.binoofactory.bmq.botbinoo.vo.FreeBoardVO;
import co.binoofactory.bmq.botbinoo.vo.MenuVO;
import co.binoofactory.bmq.botbinoo.vo.UserVO;
import net.sf.json.JSONArray;

/**
 * @Class Name : BoardController
 * @Description : Board-pages controller
 * @author botbinoo@naver.com
 * @since 2018.03.03
 * @version 1
 *
 *  Copyright (C) by botbinoo's All right reserved.
 */

@Controller
public class BoardController {

	@Autowired(required=false)
	private UserService userService;

	@Autowired(required=false)
	private MenuService menuService;
	
	@Autowired(required=false)
	private FreeBoardService freeBoardService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * @Method Name : freeBoardView
	 * @Description : free-Board view page (리스트화면, 입력화면, 상세화면, 수정화면)
	 * @author botbinoo@naver.com
	 * @since 2018.03.03
	 * @last 2018.03.03
	 * @param
	 *  - url path {value, detail}.
	 * @return 
	 *  - view page.
	 *  Copyright (C) by botbinoo's All right reserved.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/free-board/{value}/{detail}", method = RequestMethod.GET)
	public String freeBoardView (
			Locale locale, 
			Model model,
			HttpServletRequest req,
			@PathVariable("value") String value,
			@PathVariable(value="detail", required=false) String detail
		) {
		
		try {
			logger.debug("in foard view.");
			// menu
			List<MenuVO> resultList = menuService.selectMenuList(new MenuVO());
			model.addAttribute("menuList", resultList );
			
			// user-grade : session-key proof
			// 리스트, 뷰 - 보호 게시물은 자기 자신만 볼 수 있음(숨김 게시물은 검색해도 안나옴)
			// 뷰 - 게시물 수정은 자기 자신만 할 수 있음(비회원인 경우 누구나 비번만 알면 수정가능)
			// 뷰 - 공지 게시물은 관리자만 게시, 수정할 수 있음.
			
			HttpSession session = req.getSession();
			FreeBoardVO fboardVO = new FreeBoardVO();
			UserVO usrVO = new UserVO();
			
			if(session != null) {
				// first, session not null.
				usrVO.setUserid((session.getAttribute("userid") != null ?
						session.getAttribute("userid")+"" : ""));				// 회원 ID
				usrVO.setUserseckey((session.getAttribute("userkey") != null ?
						session.getAttribute("userkey")+"" : ""));;				// 회원 시큐리티키
						
				UserVO resultVO = userService.selectUser(usrVO);
				if(resultVO == null) {
					// 거짓 세션 : 1) 회원탈퇴를 하였으나 세션이 살아있음. 2) 강제로 가짜 세션을 추가하여 침입한 해커
					// 비회원과 동일한 처리가 되도록 수정한다.
					fboardVO.setUserid("비회원");										// 회원 ID
					session.invalidate();
				} else {
					fboardVO.setUserid(resultVO.getUserid());
					usrVO.setUsercode( resultVO.getUsercode() );
				}
				
			} else {
				fboardVO.setUserid("비회원");										// 회원 ID
				usrVO.setUsercode(0);											// 회원 코드
			}
			model.addAttribute("userVO", usrVO);
			
			String pageName = "botbinoo/page/error/error";
			
			if( "list".equals(value) ) {
				
				FreeBoardVO fsearchVO = new FreeBoardVO();
				if (detail.isEmpty() || detail == null) {
					fsearchVO.setCurrentPage(1);
				}else {
					if(detail.trim().length()==0 || !detail.matches("^[0-9]*$")) {
						fsearchVO.setCurrentPage(1);
					} else {
						fsearchVO.setCurrentPage(Integer.parseInt(detail));
					}
				}
				List<FreeBoardVO> boardList = freeBoardService.selectBoardList( fsearchVO );
				model.addAttribute("boardList", boardList);
				pageName = "botbinoo/page/bbs/normalList";
				
			} else if( "insert".equals(value) ) {
				// 입력은 누구나.
				model.addAttribute("boardType", "add");
				pageName = "botbinoo/page/bbs/normalDetails";
				
			} else if( "update".equals(value) || "view".equals(value) ) {
				
				FreeBoardVO fsearchVO = new FreeBoardVO();
				if (!(detail.isEmpty() || detail == null)) {
					if(detail.trim().length()!=0 && detail.matches("^[0-9]*$")) {
						fsearchVO.setSeq( Integer.parseInt(detail) );
					}
				}
				if(fsearchVO.getSeq() == null) {
					throw new Exception();
				}
				FreeBoardVO resultVO = freeBoardService.selectBoard(fsearchVO);
				model.addAttribute("boardItem", resultVO);
				model.addAttribute("boardType", ("update".equals(value) ? "edit" : "view"));
				pageName = "botbinoo/page/bbs/normalDetails";
			}
			logger.debug(pageName);
			
			model.addAttribute("pageName", pageName);
			return "botbinoo/framelib/template";
		} catch (Exception e) {
			return "botbinoo/page/error/error";
		}
	}
	

	/**
	 * @Method Name : freeBoardProc
	 * @Description : free-Board proc (입력, 출력, 수정, 보호해제)
	 * @author botbinoo@naver.com
	 * @since 2018.03.03
	 * @last 2018.03.03
	 * @param
	 *  - url path {value, detail} and VO params.
	 * @return 
	 *  - sql result json.
	 *  Copyright (C) by botbinoo's All right reserved.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/free-board/proc/{value}/{detail}", method = RequestMethod.POST)
	public @ResponseBody JSONArray freeBoardProc (
			HttpServletRequest req,
			@ModelAttribute(value="dataVO") @Validated FreeBoardVO dataVO,
			@PathVariable("value") String value,
			@PathVariable("detail") String detail
		) {
		JSONArray resultArray = new JSONArray();
		try {
			logger.debug("in foard proc.");
			
			HttpSession session = req.getSession();
			FreeBoardVO fboardVO = new FreeBoardVO();
			UserVO usrVO = new UserVO();
			
			if(session != null) {
				// first, session not null.
				usrVO.setUserid((session.getAttribute("userid") != null ?
						session.getAttribute("userid")+"" : ""));				// 회원 ID
				usrVO.setUserseckey((session.getAttribute("userkey") != null ?
						session.getAttribute("userkey")+"" : ""));;				// 회원 시큐리티키
						
				UserVO resultVO = userService.selectUser(usrVO);
				if(resultVO == null) {
					// 거짓 세션 : 1) 회원탈퇴를 하였으나 세션이 살아있음. 2) 강제로 가짜 세션을 추가하여 침입한 해커
					// 비회원과 동일한 처리가 되도록 수정한다.
					fboardVO.setUserid("비회원");									// 회원 ID
					session.invalidate();
				} else {
					fboardVO.setUserid(resultVO.getUserid());
					usrVO.setUsercode( resultVO.getUsercode() );
				}
				
			} else {
				fboardVO.setUserid("비회원");										// 회원 ID
				usrVO.setUsercode(0);											// 회원 코드
			}
			
			resultArray.add(0, value);
			
			if ( "insert".equals(value) ) {

				freeBoardService.insertBoard(dataVO);
				resultArray.add(1, "S");
				
			} else if ( "update".equals(value) || "delete".equals(value) ) {
				
				if (!(detail.isEmpty() || detail == null)) {
					if(detail.trim().length()!=0 && detail.matches("^[0-9]*$")) {
						dataVO.setSeq( Integer.parseInt(detail) );
					}
				}
				if(!(fboardVO.getUserid()+"").equals(dataVO.getUserid()) || 
						dataVO.getSeq() == null) {
					throw new Exception();
				}
				if ( "update".equals(value) ) {
					freeBoardService.updateBoard(dataVO);
				} else if ( "delete".equals(value) ) {
					freeBoardService.deleteBoard(dataVO);
				}
				resultArray.add(1, "S");
			} else if ( "protect".equals(value) ) {

				if (!(detail.isEmpty() || detail == null)) {
					if(detail.trim().length()!=0 && detail.matches("^[0-9]*$")) {
						dataVO.setSeq( Integer.parseInt(detail) );
					}
				}
				if(dataVO.getSeq() == null) {
					throw new Exception();
				}
				FreeBoardVO fsearchVO = new FreeBoardVO();
				fsearchVO.setSeq(dataVO.getSeq());
				fboardVO = freeBoardService.selectBoard(fsearchVO);
				
				if((fboardVO.getBoardkey()+"").equals(dataVO.getBoardkey())) {
					session.setAttribute("page", dataVO.getSeq());
				}
				resultArray.add(1, "S");
			}
			
			return resultArray;
		} catch (Exception e) {
			resultArray.add(1, "F");
			return resultArray;
		}
	}
}
