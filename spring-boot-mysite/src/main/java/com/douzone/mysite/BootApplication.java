package com.douzone.mysite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.douzone.mysite.security.AuthInterceptor;
import com.douzone.mysite.security.AuthLoginInterceptor;
import com.douzone.mysite.security.AuthLogoutInterceptor;
import com.douzone.mysite.security.AuthUserHandlerMethodArgumentResolver;

//@SpringBootConfiguration // spring-boot 설정파일이라고 알려주는거
//@EnableAutoConfiguration // 자동으로 설정
//@ComponentScan(value = {"com.douzone.emaillist.controller", "com.douzone.emaillist.dao"}) // 부트 어플리케이션이있는 위치부터 아래로 쫙 스캔


//  @SpringBootConfiguration 
//	@EnableAutoConfiguration 
//	@ComponentScan("com.douzone.mysite")
	
//	위 3개를 하나에 대신할수있는거
//	@SpringBootApplication
// 
@SpringBootApplication // spring boot 1.8 이상부터 작동 
// 패키지이름을 com.douzone.hellospring 이라고해주면 이 아래에 모든것을 다스캔
public class BootApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(BootApplication.class, args);
	}

}
