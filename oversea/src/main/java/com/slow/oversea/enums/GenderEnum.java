package com.slow.oversea.enums;

import lombok.Getter;

/**
 * @author Slicing
 * @date 2018/12/17 17:35
 */
@Getter
public enum GenderEnum implements CodeEnum{
	MALE(0,"男"),
	FEMALE(1,"女");
	private Integer code;
	private String mes;

	GenderEnum(Integer code, String mes) {
		this.code = code;
		this.mes = mes;
	}
}
