package com.social.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.social.commonpojo.CookieUtils;
import com.social.commonpojo.SocialResult;
import com.social.mapper.NewThingsMapper;
import com.social.mapper.UserMapper;
import com.social.pojo.NewThings;
import com.social.pojo.User;
import com.social.pojo.UserExample;
import com.social.pojo.UserExample.Criteria;
import com.social.service.ThingsService;
import com.social.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	@Autowired
	ThingsService thingsService;
	
	public SocialResult login(String username, String password,HttpServletRequest request, HttpServletResponse response) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if(list == null || list.size() == 0) {
			return SocialResult.build(400, "登录失败");
		}
		User user = list.get(0);
		if(DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
			//存入cookie
			String token = UUID.randomUUID().toString();
			CookieUtils.setCookie(request, response, "user", user.getName());
			//System.out.println(user.getName());
			//
			user.setPassword("");
			return SocialResult.ok(user);
		}
		return SocialResult.build(400, "登录失败");
	}

	public SocialResult regist(User user) {
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		try {
			userMapper.insert(user);
			return SocialResult.ok();
		}
		catch (Exception e) {
			return SocialResult.build(400, "新建用户错误");
		}
		
	}


	public SocialResult getNewthings(String username) {
		
				UserExample example = new UserExample();
				Criteria criteria = example.createCriteria();
				criteria.andNameEqualTo(username);
				List<User> list = userMapper.selectByExample(example);
				
				int userId = list.get(0).getId();  //通过username获得 
				List<NewThings> ls = thingsService.getThingsByUserid(userId);
				
				String[] things = new String[ls.size()];
				
				for(int i=0;i<things.length;i++ ) {
					things[i]=username+"+"+ls.get(i).getContent();
				}
				return SocialResult.ok(things);

	}
	
	//根据name取id
	public int getIdbyName(String username) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		int id= list.get(0).getId();
		return id;
	}

	
	
	public SocialResult postNewthings(String record,String username) {
		
		int id= getIdbyName(username);
		//System.out.println(id);
		
		
		try {
			thingsService.postThings(record,id);
			return SocialResult.ok();
		}
		catch (Exception e) {
			return SocialResult.build(400, "新建用户错误");
		}
		
	}

	

	
}
