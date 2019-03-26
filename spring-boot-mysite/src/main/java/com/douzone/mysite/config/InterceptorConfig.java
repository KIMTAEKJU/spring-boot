package com.douzone.mysite.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.douzone.mysite.security.AuthInterceptor;
import com.douzone.mysite.security.AuthLoginInterceptor;
import com.douzone.mysite.security.AuthLogoutInterceptor;
import com.douzone.mysite.security.AuthUserHandlerMethodArgumentResolver;

//@SuppressWarnings("deprecation")
//@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{

//	@Autowired
//	private AuthLoginInterceptor authLoginInterceptor;
//	
//	@Autowired
//	private AuthLogoutInterceptor authLogoutInterceptor;
//	
//	@Autowired
//	private AuthInterceptor authInterceptor;
//	
//	@Autowired
//	private AuthUserHandlerMethodArgumentResolver authUserHandlerMethodArgumentResolver;
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		
//		registry.addInterceptor(authLoginInterceptor)
//				.addPathPatterns("/user/auth");
//		
//		registry.addInterceptor(authLogoutInterceptor)
//				.addPathPatterns("/user/logout");
//		
//		registry.addInterceptor(authInterceptor)
//				.addPathPatterns( "/**" )
//				.excludePathPatterns( "/user/auth")
//				.excludePathPatterns( "/user/logout")
//				.excludePathPatterns( "/assets/*");
//		
//	}
//	
//	@Override
//	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) 
//	{
//		argumentResolvers.add(authUserHandlerMethodArgumentResolver);
//	}
}
