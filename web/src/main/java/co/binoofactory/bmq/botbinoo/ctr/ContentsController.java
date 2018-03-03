package co.binoofactory.bmq.botbinoo.ctr;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.binoofactory.bmq.botbinoo.svc.MenuService;
import co.binoofactory.bmq.botbinoo.vo.MenuVO;

/**
 * @Class Name : ContentsController
 * @Description : Contents-pages controller
 * @author botbinoo@naver.com
 * @since 2018.03.01
 * @version 1
 *
 *  Copyright (C) by botbinoo's All right reserved.
 */

@Controller
public class ContentsController {

	@Autowired(required=false)
	private MenuService menuService;
	/**
	 * @Method Name : contentsInfo 
	 * @Description : error(에러), ing(개발중), personalInfo(개인정보 취급방침 화면) pages 
	 * @author botbinoo@naver.com
	 * @since 2018.03.01
	 * @last 2018.03.01
	 * @param
	 * @return 
	 *  Copyright (C) by botbinoo's All right reserved.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/contents/page/{value}", method = RequestMethod.GET)
	public String contentsInfo(
			@PathVariable("value") String value,
			Locale locale, 
			Model model
		) {
		try {
			List<MenuVO> resultList = menuService.selectMenuList(new MenuVO());
			model.addAttribute("menuList", resultList );
			String path;
			if( "ing".equals( value+"" ) ) {
				path = "botbinoo/page/error/ing";
			} else if("personalinfo".equals( value+"" )) {
				path = "botbinoo/page/personalinfo";
			} else {
				path = "botbinoo/page/error/error";
			}
			model.addAttribute("pageName", path);
			return "botbinoo/framelib/template";
		} catch (Exception e) {
			e.printStackTrace();
			return "botbinoo/page/error/error";
		}
	}
}
