package com.slow.oversea.exception;


import com.slow.oversea.enums.ResultEnum;

/**
 * @author Slicing
 * @date 2018/12/3 17:05
 */
public class OverSeaException extends RuntimeException{
	private Integer code;

	public OverSeaException(ResultEnum resultEnum){
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}
	public OverSeaException(Integer code, String message){
		super(message);
		this.code = code;
	}
}
