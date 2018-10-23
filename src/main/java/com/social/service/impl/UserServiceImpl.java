package com.social.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.social.commonpojo.SocialResult;
import com.social.mapper.UserMapper;
import com.social.pojo.User;
import com.social.pojo.UserExample;
import com.social.pojo.UserExample.Criteria;
import com.social.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	public SocialResult login(String username, String password) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if(list == null || list.size() == 0) {
			return SocialResult.build(400, "µÇÂ¼Ê§°Ü");
		}
		User user = list.get(0);
		if(DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
			String token = UUID.randomUUID().toString();
			user.setPassword("");
			return SocialResult.ok(token);
		}
		return SocialResult.build(400, "µÇÂ¼Ê§°Ü");
	}

	public SocialResult regist(User user) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		try {
			userMapper.insert(user);
			return SocialResult.ok();
		}
		catch (Exception e) {
			return SocialResult.build(400, "ÐÂ½¨ÓÃ»§´íÎó");
		}
	}

}
