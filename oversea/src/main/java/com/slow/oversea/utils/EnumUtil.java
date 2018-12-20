package com.slow.oversea.utils;

import com.slow.oversea.enums.CodeEnum;

/**
 * @author Slicing
 * @date 2018/12/19 18:43
 */
public class EnumUtil {
	public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
		for (T each : enumClass.getEnumConstants()){
			if (each.getCode().equals(code))
				return each;
		}
		return null;
	}
}
