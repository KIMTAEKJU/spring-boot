package com.douzone.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//@SpringBootConfiguration // spring-boot 설정파일이라고 알려주는거
//@EnableAutoConfiguration // 자동으로 설정
//@ComponentScan("com.douzone.hellospring.controller") // 부트 어플리케이션이있는 위치부터 아래로 쫙 스캔

/*
 * @SpringBootConfiguration 
	@EnableAutoConfiguration 
	@ComponentScan("com.douzone.hellospring.controller")
	
	위 3개를 하나에 대신할수있는거
	@SpringBootApplication
 */
@SpringBootApplication // spring boot 1.8 이상부터 작동 
// 패키지이름을 com.douzone.hellospring 이라고해주면 이 아래에 모든것을 다스캔
public class BootApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(BootApplication.class, args);
	}

}
