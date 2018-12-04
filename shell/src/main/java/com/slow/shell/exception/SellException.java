package com.slow.shell.exception;

import com.slow.shell.enums.ResultEnum;

/**
 * @author Slicing
 * @date 2018/12/3 17:05
 */
public class SellException extends RuntimeException{
	private Integer code;

	public SellException(ResultEnum resultEnum){
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}
	public SellException(Integer code,String message){
		super(message);
		this.code = code;
	}
}
