package com.slow.shell.util;

import com.slow.shell.enums.CodeEnum;

/**
 * @author Slicing
 * @date 2018/12/6 22:39
 */
public class EnumUtil {
	public static <T extends CodeEnum> T getByCode(Integer code,Class<T> enumClass){
		for (T each : enumClass.getEnumConstants()){
			if (each.getCode().equals(code))
				return each;
		}
		return null;
	}
}
