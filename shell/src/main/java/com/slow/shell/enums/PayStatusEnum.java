package com.slow.shell.enums;

import lombok.Getter;


/**
 * @author Slicing
 * @date 2018/12/2 22:29
 */
@Getter
public enum  PayStatusEnum implements CodeEnum {
	WAIT(0,"未支付"),
	SUCCESS(1,"支付成功"),
			;
	private Integer code;
	private String msg;

	PayStatusEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
