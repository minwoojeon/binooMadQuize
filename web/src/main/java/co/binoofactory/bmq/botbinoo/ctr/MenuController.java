package co.binoofactory.bmq.botbinoo.ctr;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.binoofactory.bmq.botbinoo.svc.MenuService;
import co.binoofactory.bmq.botbinoo.vo.MenuVO;
import net.sf.json.JSONArray;

/**
 * @Class Name : MenuController
 * @Description : Menu-bar load and ajax controller
 * @author botbinoo@naver.com
 * @since 2018.02.26
 * @version 1
 *
 *  Copyright (C) by botbinoo's All right reserved.
 */

@Controller
public class MenuController {
	@Autowired(required=false)
	private MenuService menuService;
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

	/**
	 * @Method Name : getMenuItemList
	 * @Description : Menu items can get a list.
	 * @author botbinoo@naver.com
	 * @since 2018.02.26
	 * @last 2018.02.26
	 * @param
	 *  - url path only.
	 * @return 
	 *  - menu list (ajax value).
	 *  Copyright (C) by botbinoo's All right reserved.
	 * @throws Exception 
	 */
	
	@RequestMapping(value = "/menu/{value}")
	public @ResponseBody JSONArray getMenuItemList ( 
			@PathVariable("value") String value// ,
			// @ModelAttribute(value="munuVO") @Validated MenuVO menuVO // 추후 수정/ 외부 접근 불가하도록
		) throws Exception {
		logger.info("in menu list.");
		
		String pathVal = value+"";
		MenuVO menuVO = new MenuVO();
		ArrayList<MenuVO> resultList = new ArrayList<MenuVO>();
		
		if("list".equals(pathVal)) {
			// add url list -> return list.
			resultList.addAll( menuService.selectMenuList(menuVO) );
		} else if(pathVal.length() > 0){
			// not empty params -> return current list.
			resultList.add( menuService.selectMenu(menuVO) );
		} else {
			// empty params -> goto main
		}
		
		return JSONArray.fromObject(resultList);
	}
}
