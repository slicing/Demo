package com.slow.oversea.utils;

import com.google.code.kaptcha.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Slicing
 * @date 2018/12/20 16:11
 */
public class CodeUtils {
	private final static Logger logger = LoggerFactory.getLogger(CodeUtils.class);

	public static boolean checkVerifyCode(HttpServletRequest request) {
		String verifyCodeExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		String verifyCodeActual = HttpServletRequestUtils.getString(request, "verifyCodeActual");
		logger.info(verifyCodeActual);
		logger.info(verifyCodeExpected);
		if (verifyCodeActual == null || !verifyCodeActual.equals(verifyCodeExpected)) {
			return false;
		}
		return true;
	}
}
