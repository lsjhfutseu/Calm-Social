package com.social.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.social.commonpojo.CookieUtils;
import com.social.commonpojo.SocialResult;
import com.social.pojo.User;
import com.social.service.ThingsService;
import com.social.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	ThingsService thingsService;
	

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
	
	/*//获取新鲜事，及其评论
	@RequestMapping("/getnewthings")
	@ResponseBody
	public SocialResult newthings( HttpServletRequest request,HttpServletResponse response) {
		//
		String username=CookieUtils.getCookieValue(request, "user", true);//true转码
		
		
		return thingsService.getNewthings(username);
	}*/
	/*
	//提交新鲜事
	@RequestMapping("/report")
	@ResponseBody
	public SocialResult postnewthings(String content ,HttpServletRequest request,HttpServletResponse response) {
		
		String username=CookieUtils.getCookieValue(request, "user",true);  //true转码
		
		return userService.postNewthings(content,username);
		
	}*/
	
	@RequestMapping("/search_friend")
	@ResponseBody
	public SocialResult searchFriend(String username ,HttpServletRequest request,HttpServletResponse response) {
		
		return userService.searchFriend(username);
		
	}
	
	@RequestMapping("/addFriend")
	@ResponseBody
	public SocialResult addFriend(String friendname ,HttpServletRequest request,HttpServletResponse response) {
		
		String username=CookieUtils.getCookieValue(request, "user",true);  //true转码
		
		return userService.addFriend(username, friendname);
		
	}
	
	@RequestMapping("/agreeAddFriend")
	@ResponseBody
	public SocialResult agreeAddFriend(String friendname ,HttpServletRequest request,HttpServletResponse response) {
		
		String username=CookieUtils.getCookieValue(request, "user",true);  //true转码
		
		return userService.agreeAddFriend(username, friendname);
		
	}
	
	@RequestMapping("/getFriendsRequest")
	@ResponseBody
	public SocialResult getFriendsRequest(HttpServletRequest request,HttpServletResponse response) {
		
		String username=CookieUtils.getCookieValue(request, "user",true);  //true转码
		
		return userService.getFriendsRequest(username);
		
	}
	
	@RequestMapping("/rejectAddFriend")
	@ResponseBody
	public SocialResult rejectAddFriend(String friendname ,HttpServletRequest request,HttpServletResponse response) {
		
		String username=CookieUtils.getCookieValue(request, "user",true);  //true转码
		
		return userService.rejectAddFriend(username, friendname);
	}
	
	@RequestMapping("/getAllFriend")
	@ResponseBody
	public SocialResult getAllFriend(HttpServletRequest request, HttpServletResponse response) {

		String userName = CookieUtils.getCookieValue(request, "user", true); // true转码

		return userService.getAllFriend(userName);
	}
	
	
}
