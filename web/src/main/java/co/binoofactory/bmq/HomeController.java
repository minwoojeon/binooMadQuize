package co.binoofactory.bmq;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.binoofactory.bmq.botbinoo.svc.MenuService;
import co.binoofactory.bmq.botbinoo.vo.MenuVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired(required=false)
	private MenuService menuService;
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		try {
			List<MenuVO> resultList = menuService.selectMenuList(new MenuVO());
			model.addAttribute("menuList", resultList );
			return "botbinoo/framelib/template";
		} catch (Exception e) {
			e.printStackTrace();
			return "botbinoo/error/error";
		}
	}
	
}
