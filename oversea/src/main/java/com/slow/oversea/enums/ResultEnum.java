package com.slow.oversea.enums;

import lombok.Getter;

/**
 * @author Slicing
 * @date 2018/12/3 17:06
 */
@Getter
public enum ResultEnum {
	SUCCESS(0,"成功"),
	PARAM_ERROR(1,"参数不正确"),
	APPLICATION_STATUE_ERROR(2,"申请表状态不正确"),
	APPLICATION_UPDATE_FAIL(3,"状态修改失败"),
	APPLICATION_REJECT_SUCCESS(4,"申请表驳回成功"),
	APPLICATION_ADOPT_SUCCESS(5,"审核通过成功"),
	APPLICATION_UNDER_SUCCESS(7,"审核中修改成功"),
	COUNTRY_CATEGORY_DELETE_SUCCESS(6,"国家列表删除成功"),
	LOGIN_FAIL(25,"登录失败，登录信息不正确"),
	LOGOUT_SUCCESS(26,"登出成功"),
	;

	private Integer code;
	private String message;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

}
