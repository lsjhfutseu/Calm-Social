package com.social.service;

import com.social.commonpojo.SocialResult;
import com.social.pojo.User;

public interface UserService {
	//用户登陆service
	public SocialResult login(String username, String password);
	
	//用户注册service
	public SocialResult regist(User user);
	
	//public SocialResult checkusername(String username);
}

