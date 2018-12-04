package com.slow.shell.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * http请求返回的最外层对象
 * @author Slicing
 * @date 2018/12/2 10:41
 */
@Data
public class ResultVO<T> {
	/*错误码*/
	private Integer code;
	/*提示信息*/
	private String msg;
	/*返回对象*/
	private T data;
}
