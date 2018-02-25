package co.binoofactory.bmq.utils;

/**
 * @Class Name : NativeUtils
 * @Description : Native set : java-C communicate in native.
 * @author botbinoo@naver.com
 * @since 2018.02.26
 * @version 1
 *
 *  Copyright (C) by botbinoo's All right reserved.
 */

public class NativeUtils {
	
	/**
	 * @Method Name : static
	 * @Description : Before using integration extra program module, jni extra loading.
	 * @author botbinoo@naver.com
	 * @since 2018.02.26
	 * @last 2018.02.26
	 * @param
	 *  - none
	 * @return 
	 *  - void : On server, Dll loading.
	 *  Copyright (C) by botbinoo's All right reserved.
	 */
	static {
		// System.loadLibrary("BinooFactory.bf");
		// System.loadLibrary("ExCoder.bf");
	}

	/* ExCoder-coding for HyoGod */
	// public native String encoding(String key, String code, String data);
	// public native String decoding(String key, String code, String data);
	
	/* BinooFactory */
	// public native String extraCreateKey(String data);
	// public native String extraCreateCode(String data);
	// public native String hiddenText(String data, Integer len);
}
