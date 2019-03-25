package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController 
{
	@RequestMapping({"/hello", "/a/b/c/d"}) // 어떤요청을 이 url로 매핑한다  /hellospring(톰캣에있음)/hello 서블릿 컨텍스트path 이것도 기술이기때문에 배제
	public String hello(){
		return "hello"; // 커몬 프러퍼티에 설정을 해줄수있다 
		// 빈이나 java설정 같은건 부트가 알아서 다해놓기때문에 각 옵션에 대한값만 설정해놓으면된다
	}
}
