package com.slow.shell.handler;

import com.slow.shell.config.ProjectUrlConfig;
import com.slow.shell.exception.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Slicing
 * @date 2018/12/9 22:02
 */
@ControllerAdvice
public class SellerExceptionHandler {
	@Autowired
	private ProjectUrlConfig projectUrlConfig;
	//拦截登录异常
	@ExceptionHandler(value = SellerAuthorizeException.class)
	public ModelAndView handlerSellerAuthorizeException(){
		return new ModelAndView("redirect:"
				.concat(projectUrlConfig.getWechatOpenAuthorize())
		.concat("/sell/wechat/qrAuthorize")
		.concat("?returnUrl=")
		.concat(projectUrlConfig.getSell())
		.concat("/sell/seller/login"));
	}
}
