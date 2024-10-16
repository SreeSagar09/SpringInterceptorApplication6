package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.app.interceptor.ActionHandlerInterceptor1;
import com.app.interceptor.ActionHandlerInterceptor2;
import com.app.interceptor.ActionHandlerInterceptor3;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.app"})
public class AppConfig implements WebMvcConfigurer {
	
	@Autowired
	private ActionHandlerInterceptor1 actionHandlerInterceptor1;
	
	@Autowired
	private ActionHandlerInterceptor2 actionHandlerInterceptor2;
	
	@Autowired
	private ActionHandlerInterceptor3 actionHandlerInterceptor3;
	
	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		InterceptorRegistration interceptorRegistration1 = interceptorRegistry.addInterceptor(actionHandlerInterceptor1);
		interceptorRegistration1.addPathPatterns("/action/actionHandler1", "/action/actionHandler2", "/action/actionHandler3");
		interceptorRegistration1.order(1);
		
		InterceptorRegistration interceptorRegistration2 = interceptorRegistry.addInterceptor(actionHandlerInterceptor2);
		interceptorRegistration2.addPathPatterns("/action/actionHandler1", "/action/actionHandler2", "/action/actionHandler3");
		interceptorRegistration2.order(2);
		
		InterceptorRegistration interceptorRegistration3 = interceptorRegistry.addInterceptor(actionHandlerInterceptor3);
		interceptorRegistration3.addPathPatterns("/action/actionHandler1", "/action/actionHandler2", "/action/actionHandler3");
		interceptorRegistration3.order(0);
	}

}
