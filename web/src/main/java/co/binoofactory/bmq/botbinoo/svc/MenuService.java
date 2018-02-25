package co.binoofactory.bmq.botbinoo.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.binoofactory.bmq.botbinoo.vo.MenuVO;

/**
 * @Class Name : MenuService
 * @Description : Menu about processing
 * @author botbinoo@naver.com
 * @since 2018.02.26
 * @version 1
 *
 * Copyright (C) by botbinoo's All right reserved.
 */

@Service("menuService")
public class MenuService {
	@Autowired(required=false)
	private MenuDAO menuDAO;

	/**
	 * @Method Name : insert/update/delete/select/list/cnt Menu
	 * @Description : Menu items can get a list.
	 * @author botbinoo@naver.com
	 * @since 2018.02.26
	 * @last 2018.02.26
	 * @param
	 *  - MenuVO : VO
	 * @return 
	 *  - DB access and result.
	 *  Copyright (C) by botbinoo's All right reserved.
	 */
	public void insertMenu(MenuVO item) throws Exception {
		menuDAO.insertItem(item);
	}
	public void updateMenu(MenuVO item) throws Exception {
		menuDAO.updateItem(item);
	}
	public void deleteMenu(MenuVO item) throws Exception {
		menuDAO.deleteItem(item);
	}
	public MenuVO selectMenu(MenuVO item) throws Exception {
		return menuDAO.selectItem(item);
	}
	public List<MenuVO> selectMenuList(MenuVO item) throws Exception {
		return menuDAO.selectItemList(item);
	}
	public int selectMenuListTotCnt(MenuVO item) throws Exception {
		return menuDAO.selectItemListTotCnt(item);
	}
}
