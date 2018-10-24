package com.social.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.social.commonpojo.SocialResult;
import com.social.pojo.User;
import com.social.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/regist")
	@ResponseBody
	public SocialResult regist(String username, String userpassword) {
		User user = new User();
		user.setName(username);
		user.setPassword(userpassword);
		return userService.regist(user);
	}

	@RequestMapping("/login")
	@ResponseBody
	public SocialResult login(String username, String userpassword, HttpServletRequest request,
			HttpServletResponse response) {
		return userService.login(username, userpassword, request, response);
	}
}
