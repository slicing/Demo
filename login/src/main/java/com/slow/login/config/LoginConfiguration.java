package com.slow.login.config;

import com.slow.login.interceptor.LoginInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class LoginConfiguration implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		LoginInterceptor loginInterceptor = new LoginInterceptor();
		InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
		loginRegistry.addPathPatterns("/**");
		loginRegistry.excludePathPatterns("/");
		loginRegistry.excludePathPatterns("/login");
		loginRegistry.excludePathPatterns("/loginOut");
	}

}
