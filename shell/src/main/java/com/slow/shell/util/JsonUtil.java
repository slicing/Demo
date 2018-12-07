package com.slow.shell.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Slicing
 * @date 2018/12/6 10:56
 */
public class JsonUtil {
	public static String toJson(Object object){
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		return gson.toJson(object);
	}
}
