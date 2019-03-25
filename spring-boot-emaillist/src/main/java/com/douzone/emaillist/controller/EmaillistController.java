package com.douzone.emaillist.controller;

import java.util.List; 

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.douzone.emaillist.dao.EmaillistDao;
import com.douzone.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController 
{
	@Autowired
	private EmaillistDao emaillistDao; // 우리가 직접 new를 하지않고 컨테이너에게 맡김
	
//	@ResponseBody
//	@RequestMapping({"", "/list", "/main"})
//	public ModelAndView list()
//	{
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("list", emaillistDao.getList());
//		mav.setViewName("/WEB-INF/views/list.jsp");
//		return mav;
//	}
	
	
	@RequestMapping({"", "/list", "/main"})
	public String list(Model model) // 파라미터에 모델 객체를 줌? (넘길데이터가있으면)  넘길데이터가 있으니 모델이 넣어서 호출
	{
		model.addAttribute("list", emaillistDao.getList()); // list 함수가 jsp로 넘겨줘야하는게 있다
		return "/list";
	}
	
	@RequestMapping("/form")
	public String form()
	{
		return "/form";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(EmaillistVo emaillistVo)
	{
		emaillistDao.insert(emaillistVo);
		
		return "redirect:/";
		
	}
}
