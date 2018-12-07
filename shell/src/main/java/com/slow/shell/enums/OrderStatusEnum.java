package com.slow.shell.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @author Slicing
 * @date 2018/12/2 22:20
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {
	NEW(0,"新订单"),
	FINISGED(1,"完结"),
	CANCEL(2,"已取消"),
			;
	private Integer code;
	private String msg;

	OrderStatusEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
