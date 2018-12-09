package com.slow.shell.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Slicing
 * @date 2018/12/9 22:02
 */
@ControllerAdvice
public class SellerExceptionHandler {
	//拦截登录异常
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ModelAndView handlerSellerAuthorizeException(){

	}
}
