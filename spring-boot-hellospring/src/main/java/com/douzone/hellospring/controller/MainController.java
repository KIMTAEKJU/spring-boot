package com.douzone.hellospring.controller;

import java.io.Writer; 

import javax.servlet.http.HttpServletRequest; // 톰캣라이브러리가 없으면 에러남

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController 
{
	@ResponseBody
	@RequestMapping({"/main", ""}) // 메소드 단독 매핑
	public String main()
	{
		return "MainController:main()";
	}
	
	@ResponseBody
	@RequestMapping("/main/a/b/c/d") // 메소드 단독 매핑
	public String main2()
	{
		return "MainController:main2()";
	}
	
	/*
	 * 비추천
	 * 기술이 침투됨
	 */
	@ResponseBody
	@RequestMapping("/main3") // 메소드 단독 매핑
	public String main3(HttpServletRequest request, Writer out)
	{
		String name = request.getParameter("n"); // 이렇게하면 다른데서 컨트롤러 사용x 이식서이 떨어짐
		
		return "MainController:main3()";
	}
}
