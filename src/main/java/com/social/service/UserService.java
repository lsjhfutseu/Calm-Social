package com.social.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.social.commonpojo.SocialResult;
import com.social.pojo.NewThings;
import com.social.pojo.User;

public interface UserService {
	// 用户登陆service
	public SocialResult login(String username, String password, HttpServletRequest request,
			HttpServletResponse response);

	// 用户注册service
	public SocialResult regist(User user);

	public int getIdbyName(String userName);

	public String getNameById(int userid);

	public SocialResult addFriend(String username, String friendname);

	public SocialResult searchFriend(String username);

	public SocialResult agreeAddFriend(String username, String friendname);

	public SocialResult rejectAddFriend(String username, String friendname);

	public SocialResult getFriendsRequest(String username);
	
	public User getUserbyName(String userName);

	public SocialResult getAllFriend(String userName);

}
