package com.social.service;

import com.social.commonpojo.SocialResult;
import com.social.pojo.User;

public interface UserService {
	//�û���½service
	public SocialResult login(String username, String password);
	
	//�û�ע��service
	public SocialResult regist(User user);
	
	//public SocialResult checkusername(String username);
}

