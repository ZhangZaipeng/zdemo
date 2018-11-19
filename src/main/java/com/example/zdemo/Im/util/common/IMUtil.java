package com.example.zdemo.Im.util.common;

import java.util.Random;

public class IMUtil {

	/**
	 * 随机数
	 * 
	 * @return
	 */
	public static int random() {
		Random random = new Random();
		return random.nextInt(1000000);
	}
	
	public static int getCurrentTimeMillis() {
		String string = System.currentTimeMillis() + "";
		return Integer.parseInt(string.substring(0, 7));
	}
	
}
