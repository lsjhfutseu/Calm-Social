package com.social.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.social.commonpojo.SocialResult;
import com.social.pojo.NewThings;
import com.social.pojo.User;

public interface UserService {
	//�û���½service
	public SocialResult login(String username, String password,HttpServletRequest request, HttpServletResponse response);
	
	//�û�ע��service
	public SocialResult regist(User user);

	public SocialResult getNewthings(String username);
	
	public int getIdbyName(String userName);
	
	public String getNameById(int userid);
	
	public SocialResult postNewthings(String record,String username);
	
	public SocialResult addFriend(String username, String friendname);
	public SocialResult searchFriend(String username);
	
}

