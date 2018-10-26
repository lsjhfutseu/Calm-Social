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
<<<<<<< HEAD
	ThingsService thingsService ;
=======
	ThingsService thingsService;
>>>>>>> 19593c8f86429dfa8017019af1d1daf5a49352f1
	
	public SocialResult login(String username, String password,HttpServletRequest request, HttpServletResponse response) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if(list == null || list.size() == 0) {
			return SocialResult.build(400, "��¼ʧ��");
		}
		User user = list.get(0);
		
		System.out.println(user.getName());
		
		if(DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
			//����cookie
			String token = UUID.randomUUID().toString();
			CookieUtils.setCookie(request, response, "user", user.getName());
			//
			user.setPassword("");
			return SocialResult.ok(user);
		}
		return SocialResult.build(400, "��¼ʧ��");
	}

	public SocialResult regist(User user) {
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		try {
			userMapper.insert(user);
			return SocialResult.ok();
		}
		catch (Exception e) {
			return SocialResult.build(400, "�½��û�����");
		}
		
	}

<<<<<<< HEAD
	public SocialResult getNewthings(String username) {

		//username = "20181026";
		System.out.println(username);
		
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		int userId = list.get(0).getId();
		System.out.println(userId);
		
		//int userId = 1;  //ͨ��username���
		
		//ThingsService thingsService = new ThingsServiceImpl();
		
		List<NewThings> ls = thingsService.getThingsByUserid(userId);
		
		System.out.println(ls.size());
		
		String[] things = new String[1];
		
		for(int i=0;i<things.length;i++ ) {
			things[i]=username+"+"+ls.get(i).getContent();
		}
		
		
		return SocialResult.ok(things);
	}

	
=======
	public SocialResult getNewthings(String username) {	
				UserExample example = new UserExample();
				Criteria criteria = example.createCriteria();
				criteria.andNameEqualTo(username);
				List<User> list = userMapper.selectByExample(example);
				int userId = list.get(0).getId();  //ͨ��username��� 
				
				List<NewThings> ls = thingsService.getThingsByUserid(userId);
				
				String[] things = new String[ls.size()];
				
				for(int i=0;i<things.length;i++ ) {
					things[i]=username+"+"+ls.get(i).getContent();
				}
				return SocialResult.ok(things);
>>>>>>> 19593c8f86429dfa8017019af1d1daf5a49352f1

	}
}
