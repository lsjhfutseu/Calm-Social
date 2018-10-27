package com.social.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.social.commonpojo.CookieUtils;
import com.social.commonpojo.SocialResult;
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
			CookieUtils.setCookie(request, response, "user", user.getName(), true);
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
		
		int userId = -1;
		String[] friendsId=null; //好友id
		if(!list.isEmpty()) {
			userId = list.get(0).getId();  //通过username获得 
			if(list.get(0).getFriend() !=null)
				friendsId= list.get(0).getFriend().split(",");
		}
		

		
		//获取所有人的新鲜事
		if(userId != -1) {
			TreeMap<Integer, String> thingsmap = new TreeMap<Integer, String>();
			
			List<NewThings> ls = thingsService.getThingsByUserid(userId);
			String curUsername = getNameById(userId);
			for(int i = 0; i < ls.size(); i++) {
				NewThings temp = ls.get(i);
				thingsmap.put(temp.getId(), curUsername + "+" + temp.getContent()+"+"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(temp.getPosttime())+"+"+temp.getId());
			}
			
			
			for (int i = 0; friendsId != null && i < friendsId.length; i++) {
				List<NewThings> friendls = thingsService.getThingsByUserid(Integer.valueOf(friendsId[i]));
				String usname = getNameById(Integer.valueOf(friendsId[i]));
				for(int j = 0; j < friendls.size(); j++) {
					NewThings temp = friendls.get(j);
					thingsmap.put(temp.getId(), usname + "+" + temp.getContent()+"+"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(temp.getPosttime())+"+"+temp.getId());
				}
			}
			
	
			int num=thingsmap.size();//总共newthingsId数
			String[] things = new String[thingsmap.size()];
			//自然排序--递增
			Set<Integer> set = thingsmap.keySet();
			for (Integer key : set) {
				String value = thingsmap.get(key);
				things[num-1]=value;
				num--;
			}
			
			return SocialResult.ok(things);
		}
		
		return SocialResult.build(400,"无内容");

	}
	
	//根据name取id
	public int getIdbyName(String username) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if(list.isEmpty())
			return -1;
		int id= list.get(0).getId();
		return id;
	}
	
	//
	public String getNameById(int userid) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(userid);
		List<User> list = userMapper.selectByExample(example);
		if(list.isEmpty())
			return null;
		String name= list.get(0).getName();
		return name;
	}
	
	

	
	
	public SocialResult postNewthings(String record,String username) {
		
		int id= getIdbyName(username);
		if(id == -1)
			return SocialResult.build(400, "未登陆");
		try {
			thingsService.postThings(record,id);
			return SocialResult.ok();
		}
		catch (Exception e) {
			return SocialResult.build(400, "新建用户错误");
		}
		
	}

	public SocialResult addFriend(String username, String friendname) {
		if(username == friendname)
			return SocialResult.build(445, "不可添加自己为好友");
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if(list.isEmpty())
			return SocialResult.build(400, "请先登录");
		User user = list.get(0);
		
		//获得朋友的ID
		int friendId = getIdbyName(friendname);
		if(friendId == -1)
			return SocialResult.build(400, "查无此人");
		String[] friends = null;
		if(user.getFriend() != null) {
			friends = user.getFriend().split(",");
		}
		for(int i = 0; friends != null && i < friends.length; ++i) {
			if(Integer.valueOf(friends[i]) == friendId) {
				return SocialResult.build(444, "不可重复添加好友");
			}
		}
		if(friends == null) {   //如果之前没好友
			user.setFriend(friendId+"");
		}else {
			user.setFriend(user.getFriend() + "," + friendId);
		}
		userMapper.updateByPrimaryKey(user);
		return SocialResult.ok();
	}

	public SocialResult searchFriend(String username) {
		int id= getIdbyName(username);
		if(id == -1)
			return SocialResult.build(400, "查无此人");
		else 
			return SocialResult.ok(username);
	}
	
	
}
