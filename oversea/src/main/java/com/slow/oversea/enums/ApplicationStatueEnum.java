package com.slow.oversea.enums;

import lombok.Getter;

/**
 * @author Slicing
 * @date 2018/12/19 10:29
 */
@Getter
public enum ApplicationStatueEnum implements CodeEnum{
	WAIT_EXAMINE(0,"等待审核"),
	IN_AUDIT(1,"审核中"),
	AUDIT_PASS(2,"审核通过"),
	REJECT(3,"驳回")
	;
	private Integer code;
	private String msg;

	ApplicationStatueEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
