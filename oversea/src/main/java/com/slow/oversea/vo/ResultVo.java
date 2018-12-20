package com.slow.oversea.vo;

import lombok.Data;

/**
 * @author Slicing
 * @date 2018/12/19 13:52
 */
@Data
public class ResultVo<T> {
	/*错误码*/
	private Integer code;
	/*提示信息*/
	private String msg;
	/*返回对象*/
	private T data;
}
