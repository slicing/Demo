package com.slow.oversea.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Slicing
 * @date 2018/12/20 15:38
 */
public class HttpServletRequestUtils {
	public static Boolean getBollean(HttpServletRequest request,String key){
		try {
			return Boolean.valueOf(request.getParameter(key));
		}catch (Exception e){
			return false;
		}
	}


	public static String getString(HttpServletRequest request,String key){
		try {
			String result = request.getParameter(key);
			if (result != null)
				result = result.trim();
			if (result.equals(""))
				result = null;
			return result;
		}catch (Exception e){
			return null;
		}
	}

}
