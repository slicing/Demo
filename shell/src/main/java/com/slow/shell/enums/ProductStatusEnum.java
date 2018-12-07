package com.slow.shell.enums;

import lombok.Getter;

/**
 * @author Slicing
 * @date 2018/12/1 22:31
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
	UP(0,"在架"),
	DOWN(1,"下架")
	;
	private Integer code;
	private String message;

	ProductStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
