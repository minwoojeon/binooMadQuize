package co.binoofactory.bmq.botbinoo.svc;

import org.springframework.stereotype.Component;

import co.binoofactory.bmq.botbinoo.vo.MenuVO;
import co.binoofactory.bmq.commons.CommonDAO;

/**
 * @Class Name : MenuDAO
 * @Description : Menu DB access object
 * @author botbinoo@naver.com
 * @since 2018.02.26
 * @version 1
 *
 * Copyright (C) by botbinoo's All right reserved.
 */
@Component("menuDAO")
public class MenuDAO extends CommonDAO<MenuVO> {
	// In action.
	public MenuDAO(){
		mapper="MenuMapper";
	}
}
