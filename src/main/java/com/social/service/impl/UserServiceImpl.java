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
			user.setPassword("");
			try {
				return SocialResult.ok(username);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return SocialResult.build(400, "登录失败");
	}

	public SocialResult regist(User user) {
		//校验
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(user.getName());
		List<User> list = userMapper.selectByExample(example);
		
		if(list.size() != 0) {
			return SocialResult.build(411, "新建用户错误");
		}
		
		//注册
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		try {
			userMapper.insert(user);
			return SocialResult.ok();
		}
		catch (Exception e) {
			return SocialResult.build(400, "新建用户错误");
		}
		
	}

/*
	//获取新鲜事及其评论
	public SocialResult getNewthings(String username) {
		//获取userId 和 若干friendId
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		
		int userId = -1;
		String[] friendsId=null; //好友id
		if(!list.isEmpty()) {
			userId = list.get(0).getId();  //通过username获得 
			if(list.get(0).getFriend() !=null && !"".equals(list.get(0).getFriend()))
				friendsId= list.get(0).getFriend().split(",");
		}

		//获取所有人的新鲜事
		if(userId != -1) {
			TreeMap<Integer, String> thingsmap = new TreeMap<Integer, String>();
			
			List<NewThings> ls = thingsService.getThingsByUserid(userId);
			String curUsername = getNameById(userId);
			for(int i = 0; i < ls.size(); i++) {
				NewThings nt = ls.get(i);
				thingsmap.put(nt.getId(), curUsername + "+" + nt.getContent()+"+"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(nt.getPosttime())+"+"+nt.getId());
			
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
			String[] things = new String[num];
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
	*/
	/**
	 * 根据name取id
	 */
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
	
	/**
	 * 
	 */
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
	
	

	/*
	
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
	*/
	

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
		if(user.getFriend() != null && !"".equals(user.getFriend())) {
			friends = user.getFriend().split(",");
		}
		for(int i = 0; friends != null && i < friends.length; ++i) {
			if(Integer.valueOf(friends[i]) == friendId) {
				return SocialResult.build(444, "不可重复添加好友");
			}
		}
		
		//往被添加的好友的请求里加数据
		UserExample example1 = new UserExample();
		Criteria criteria1 = example1.createCriteria();
		criteria1.andNameEqualTo(friendname);
		List<User> friendList = userMapper.selectByExample(example1);
		User friendUser = friendList.get(0);
		
		String[] friendRequests = null;
		if(friendUser.getFriendRequest() != null && !"".equals(friendUser.getFriendRequest())) {
			friendRequests = friendUser.getFriendRequest().split(",");
			for(int i = 0; i < friendRequests.length; i++) {  //判断是否重复申请
				if(Integer.valueOf(friendRequests[i]) == user.getId()) {
					return SocialResult.build(444, "不可重复添加好友");
				}
			}
		}
		
		if(friendRequests == null) {   //如果之前没好友请求
			friendUser.setFriendRequest(user.getId()+"");
		}
		else {
			friendUser.setFriendRequest(friendUser.getFriendRequest() + "," + user.getId());
		}
		userMapper.updateByPrimaryKey(friendUser);
		return SocialResult.ok();
	}

	public SocialResult searchFriend(String username) {
		int id= getIdbyName(username);
		if(id == -1)
			return SocialResult.build(400, "查无此人");
		else 
			return SocialResult.ok(username);
	}

	public SocialResult agreeAddFriend(String username, String friendname) {
		//首先加入自己的friend里
		if(username == friendname)
			return SocialResult.build(445, "不可添加自己为好友");
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if(list.isEmpty())
			return SocialResult.build(400, "请先登录");
		User user = list.get(0);
		int friendId = getIdbyName(friendname);
		String[] friends = null;
		if(user.getFriend() != null && !"".equals(user.getFriend())) {
			friends = user.getFriend().split(",");
		}
		for(int i = 0; friends != null && i < friends.length; ++i) {
			if("".equals(friends[i]))
				continue;
			if(Integer.valueOf(friends[i]) == friendId) {
				return SocialResult.build(444, "不可重复添加好友");
			}
		}
		//处理好友请求str
		String afterFriendRequset = user.getFriendRequest();
		
		if(user.getFriendRequest().indexOf(friendId+"") == 0 && !user.getFriendRequest().contains(",")) {
			//说明只有一个请求
			afterFriendRequset = user.getFriendRequest().replace(friendId+"", "");  //接受后新的好友请求
		}else if(user.getFriendRequest().indexOf(friendId+"") == 0) {
			//说明是第一个请求,且不止一个请求
			afterFriendRequset = user.getFriendRequest().replace(friendId+",", "");  //接受后新的好友请求
		}
		else {
			afterFriendRequset = user.getFriendRequest().replace(","+friendId, "");  //接受后新的好友请求
		}
		
		user.setFriendRequest(afterFriendRequset);
		
		if(friends == null) {  //原先无朋友
			user.setFriend(friendId+"");
		}else {
			user.setFriend(user.getFriend()+","+friendId);
		}
		userMapper.updateByPrimaryKey(user);
		
		
		
		//再处理朋友的friend
		UserExample example1 = new UserExample();
		Criteria criteria1 = example1.createCriteria();
		criteria1.andNameEqualTo(friendname);
		List<User> friendList = userMapper.selectByExample(example1);
		User friendUser = friendList.get(0);
		
		String[] friend_friends = null;
		if(friendUser.getFriend() != null && !"".equals(friendUser.getFriend())) {
			friend_friends = friendUser.getFriend().split(",");
		}
		for(int i = 0; friend_friends != null && i < friend_friends.length; ++i) {
			if(Integer.valueOf(friend_friends[i]) == user.getId()) {
				return SocialResult.build(444, "不可重复添加好友");
			}
		}
		
		if(friend_friends == null) {  //原先无朋友
			friendUser.setFriend(user.getId()+"");
		}else {
			friendUser.setFriend(friendUser.getFriend()+","+user.getId());
		}
		userMapper.updateByPrimaryKey(friendUser);
		
		
		return SocialResult.ok(friendname);
	}

	//查询好友请求，返回name数组
	public SocialResult getFriendsRequest(String username) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if(list.isEmpty())
			return SocialResult.build(400, "请先登录");
		User user = list.get(0);
		String[] name = null;
		if(user.getFriendRequest() != null && !"".equals(user.getFriendRequest())) {  //如果好友请求不为空
			String[] id = user.getFriendRequest().split(",");
			name = new String[id.length];
			for(int i = 0; i < id.length; ++i) {
				name[i] = getNameById(Integer.valueOf(id[i]));
			}
		}
		return SocialResult.ok(name);
	}

	public SocialResult rejectAddFriend(String username, String friendname) {
		//查找username对象
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if(list.isEmpty()) {
			return SocialResult.build(400, "用户名无注册");
		}
		User user = list.get(0);
		
		//查找friendname对象
		UserExample example1 = new UserExample();
		Criteria criteria1 = example1.createCriteria();
		criteria1.andNameEqualTo(friendname);
		List<User> friendList = userMapper.selectByExample(example1);
		if(friendList.isEmpty()) {
			return SocialResult.build(400, "有毛个申请的朋友");
		}
		int friendId = friendList.get(0).getId();
		
		//删除
		String FriendRequset = user.getFriendRequest();
		if(!FriendRequset.contains(friendId+"")) {
			return SocialResult.build(400, "有毛申请的朋友");
		}
		

		if (user.getFriendRequest().indexOf(friendId + "") == 0 && !user.getFriendRequest().contains(",")) {
			// 说明只有一个请求
			FriendRequset = user.getFriendRequest().replace(friendId + "", ""); // 接受后新的好友请求
		} else if (user.getFriendRequest().indexOf(friendId + "") == 0) {
			// 说明是第一个请求,且不止一个请求
			FriendRequset = user.getFriendRequest().replace(friendId + ",", ""); // 接受后新的好友请求
		} else {
			FriendRequset = user.getFriendRequest().replace("," + friendId, ""); // 接受后新的好友请求
		}

		user.setFriendRequest(FriendRequset);
		userMapper.updateByPrimaryKey(user);
	
		
		return SocialResult.ok(username);
	}

	public User getUserbyName(String userName) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(userName);
		List<User> list = userMapper.selectByExample(example);
		if(list.isEmpty())
			return null;
	
		return list.get(0);
	}
	
	
	
}
