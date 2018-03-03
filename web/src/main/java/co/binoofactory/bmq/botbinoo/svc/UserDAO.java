package co.binoofactory.bmq.botbinoo.svc;

import co.binoofactory.bmq.botbinoo.vo.UserVO;
import co.binoofactory.bmq.commons.CommonDAO;

/**
 * @Class Name : UserDAO
 * @Description : User data DB access object
 * @author botbinoo@naver.com
 * @since 2018.02.28
 * @version 1
 *
 * Copyright (C) by botbinoo's All right reserved.
 */
public class UserDAO extends CommonDAO<UserVO> {
	// In action.
	public UserDAO(){
		mapper="UserMapper";
	}
}
