package com.douzone.mysite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.dto.JSONResult;
import com.douzone.mysite.service.UserService;

@Controller("userApiController")
@RequestMapping("/user/api")
public class UserController 
{
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping("/checkemail")
	public JSONResult checkEmail(@RequestParam(value = "email", required = true, defaultValue = "") String email)
	{
		Boolean exist = userService.existEmail(email);
		return JSONResult.success(exist);
	}
}
