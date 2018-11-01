package com.social.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/MyRegist")
	public String toRegist(HttpServletRequest request,HttpServletResponse response) {
		 return "regist";     
	}
	
	@RequestMapping("/MyHome")
	public String toHome(HttpServletRequest request,HttpServletResponse response) {
		 return "home";     
	}
	
	@RequestMapping("/MyLogin")
	public String toLogin(HttpServletRequest request,HttpServletResponse response) {
		 return "login";     
	}
}
