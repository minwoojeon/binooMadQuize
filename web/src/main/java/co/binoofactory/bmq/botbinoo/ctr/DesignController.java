package co.binoofactory.bmq.botbinoo.ctr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Class Name : DesignController
 * @Description : Html5 Design Guide
 * @author botbinoo@naver.com
 * @since 2018.02.21
 * @version 1
 *
 *  Copyright (C) by botbinoo's All right reserved.
 */

@Controller
public class DesignController {

	private static final Logger logger = LoggerFactory.getLogger(DesignController.class);

	/**
	 * @Method Name : designGuideView
	 * @Description : Html5 Design Guide start line
	 * @author botbinoo@naver.com
	 * @since 2018.02.21
	 * @last 2018.02.21
	 * @param
	 *  - url path only.
	 * @return 
	 *  - views (method).
	 *  Copyright (C) by botbinoo's All right reserved.
	 */
	@RequestMapping(value = "/design/{value}", method = RequestMethod.GET)
	public String designGuideView ( 
			@PathVariable("value") String value
		) {
		logger.info("in design guide.");
		
		String pathVal = value+"";
		String direction;

		switch(pathVal) {
			case "":
				// empty params -> goto main.
				direction = "redirect:/";
				break;
			case "guide":
				// add url guide -> goto design guide.
				direction = "botbinoo/design/index";
				break;
			case "main":
				// add url main -> goto main design.
				direction = "botbinoo/design/main";
				break;
			case "contents":
				// add url contents -> goto contents design.
				direction = "botbinoo/design/contents";
				break;
			default:
				// none understood params -> goto error.
				direction = "botbinoo/error/error";
				break;
		}
		return direction;
	}
	
}
