package com.slow.shell.util;

import java.util.Random;

/**
 * @author Slicing
 * @date 2018/12/3 17:16
 */
public class KeyUtil {
	/*
	* 生成唯一的主键
	* 格式：时间+随机数
	* @return
	* */
	public static synchronized String genUnitqueKey(){
		Random random = new Random();
		Integer number = random.nextInt(900000) + 100000;
		return System.currentTimeMillis() + String.valueOf(number);
	}
}
