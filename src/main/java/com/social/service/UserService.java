package com.social.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.social.commonpojo.SocialResult;
import com.social.pojo.User;

public interface UserService {
	//�û���½service
	public SocialResult login(String username, String password,HttpServletRequest request, HttpServletResponse response);
	
	//�û�ע��service
	public SocialResult regist(User user);
	

}

