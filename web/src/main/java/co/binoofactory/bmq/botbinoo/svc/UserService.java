package co.binoofactory.bmq.botbinoo.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.binoofactory.bmq.botbinoo.vo.UserVO;

/**
 * @Class Name : UserService
 * @Description : User about DB processing
 * @author botbinoo@naver.com
 * @since 2018.02.28
 * @version 1
 *
 * Copyright (C) by botbinoo's All right reserved.
 */

@Service("userService")
public class UserService {
	@Autowired(required=false)
	private UserDAO userDAO;

	/**
	 * @Method Name : insert/update/delete/select/list/cnt Users
	 * @Description : User items can get a list.
	 * @author botbinoo@naver.com
	 * @since 2018.02.28
	 * @last 2018.02.28
	 * @param
	 *  - UserVO : VO
	 * @return 
	 *  - DB access and result.
	 *  Copyright (C) by botbinoo's All right reserved.
	 */
	public void insertUser(UserVO item) throws Exception {
		userDAO.insertItem(item);
	}
	public void updateUser(UserVO item) throws Exception {
		userDAO.updateItem(item);
	}
	public void deleteUser(UserVO item) throws Exception {
		userDAO.deleteItem(item);
	}
	public UserVO selectUser(UserVO item) throws Exception {
		return userDAO.selectItem(item);
	}
	public List<UserVO> selectUserList(UserVO item) throws Exception {
		return userDAO.selectItemList(item);
	}
	public int selectUserListTotCnt(UserVO item) throws Exception {
		return userDAO.selectItemListTotCnt(item);
	}
}
