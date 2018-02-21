package co.binoofactory.bmq.commons;

import org.springframework.stereotype.Component;

/**
 * @Class Name : CustomStringUtils
 * @Description : It is custom processing method to string data.
 * @author botbinoo@naver.com
 * @since 2018.02.22
 * @version 1
 *
 *  Copyright (C) by botbinoo's All right reserved.
 */

// @Component
public class CustomStringUtils {
	public String toHideCode(String arg, int start, int end) throws Exception{
		String item = new String(arg);
		int len = item.length();
		if( start >= len || start < 0 || end < 0 ){
			return item;
		} else if( end >= len ){
			item = item.substring(start, len-1) + "*****";
		} else {
			item = item.substring(0, start) + "*****" + item.substring(end, len-1);
		}
		return item;
	}
}
