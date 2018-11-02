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
			return SocialResult.build(400, "��¼ʧ��");
		}
		User user = list.get(0);
		if(DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
			//����cookie
			String token = UUID.randomUUID().toString();
			CookieUtils.setCookie(request, response, "user", user.getName(), true);
			user.setPassword("");
			try {
				return SocialResult.ok(username);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return SocialResult.build(400, "��¼ʧ��");
	}

	public SocialResult regist(User user) {
		//У��
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(user.getName());
		List<User> list = userMapper.selectByExample(example);
		
		if(list.size() != 0) {
			return SocialResult.build(411, "�½��û�����");
		}
		
		//ע��
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		try {
			userMapper.insert(user);
			return SocialResult.ok();
		}
		catch (Exception e) {
			return SocialResult.build(400, "�½��û�����");
		}
		
	}

/*
	//��ȡ�����¼�������
	public SocialResult getNewthings(String username) {
		//��ȡuserId �� ����friendId
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		
		int userId = -1;
		String[] friendsId=null; //����id
		if(!list.isEmpty()) {
			userId = list.get(0).getId();  //ͨ��username��� 
			if(list.get(0).getFriend() !=null && !"".equals(list.get(0).getFriend()))
				friendsId= list.get(0).getFriend().split(",");
		}

		//��ȡ�����˵�������
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
			
			int num=thingsmap.size();//�ܹ�newthingsId��
			String[] things = new String[num];
			//��Ȼ����--����
			Set<Integer> set = thingsmap.keySet();
			for (Integer key : set) {
				String value = thingsmap.get(key);
				things[num-1]=value;
				num--;
			}
			
			return SocialResult.ok(things);
		}
		
		return SocialResult.build(400,"������");

	}
	*/
	/**
	 * ����nameȡid
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
			return SocialResult.build(400, "δ��½");
		try {
			thingsService.postThings(record,id);
			return SocialResult.ok();
		}
		catch (Exception e) {
			return SocialResult.build(400, "�½��û�����");
		}
		
	}
	*/
	

	public SocialResult addFriend(String username, String friendname) {
		if(username == friendname)
			return SocialResult.build(445, "��������Լ�Ϊ����");
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if(list.isEmpty())
			return SocialResult.build(400, "���ȵ�¼");
		User user = list.get(0);
		
		//������ѵ�ID
		int friendId = getIdbyName(friendname);
		if(friendId == -1)
			return SocialResult.build(400, "���޴���");
		String[] friends = null;
		if(user.getFriend() != null && !"".equals(user.getFriend())) {
			friends = user.getFriend().split(",");
		}
		for(int i = 0; friends != null && i < friends.length; ++i) {
			if(Integer.valueOf(friends[i]) == friendId) {
				return SocialResult.build(444, "�����ظ���Ӻ���");
			}
		}
		
		//������ӵĺ��ѵ������������
		UserExample example1 = new UserExample();
		Criteria criteria1 = example1.createCriteria();
		criteria1.andNameEqualTo(friendname);
		List<User> friendList = userMapper.selectByExample(example1);
		User friendUser = friendList.get(0);
		
		String[] friendRequests = null;
		if(friendUser.getFriendRequest() != null && !"".equals(friendUser.getFriendRequest())) {
			friendRequests = friendUser.getFriendRequest().split(",");
			for(int i = 0; i < friendRequests.length; i++) {  //�ж��Ƿ��ظ�����
				if(Integer.valueOf(friendRequests[i]) == user.getId()) {
					return SocialResult.build(444, "�����ظ���Ӻ���");
				}
			}
		}
		
		if(friendRequests == null) {   //���֮ǰû��������
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
			return SocialResult.build(400, "���޴���");
		else 
			return SocialResult.ok(username);
	}

	public SocialResult agreeAddFriend(String username, String friendname) {
		//���ȼ����Լ���friend��
		if(username == friendname)
			return SocialResult.build(445, "��������Լ�Ϊ����");
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if(list.isEmpty())
			return SocialResult.build(400, "���ȵ�¼");
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
				return SocialResult.build(444, "�����ظ���Ӻ���");
			}
		}
		//�����������str
		String afterFriendRequset = user.getFriendRequest();
		
		if(user.getFriendRequest().indexOf(friendId+"") == 0 && !user.getFriendRequest().contains(",")) {
			//˵��ֻ��һ������
			afterFriendRequset = user.getFriendRequest().replace(friendId+"", "");  //���ܺ��µĺ�������
		}else if(user.getFriendRequest().indexOf(friendId+"") == 0) {
			//˵���ǵ�һ������,�Ҳ�ֹһ������
			afterFriendRequset = user.getFriendRequest().replace(friendId+",", "");  //���ܺ��µĺ�������
		}
		else {
			afterFriendRequset = user.getFriendRequest().replace(","+friendId, "");  //���ܺ��µĺ�������
		}
		
		user.setFriendRequest(afterFriendRequset);
		
		if(friends == null) {  //ԭ��������
			user.setFriend(friendId+"");
		}else {
			user.setFriend(user.getFriend()+","+friendId);
		}
		userMapper.updateByPrimaryKey(user);
		
		
		
		//�ٴ������ѵ�friend
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
				return SocialResult.build(444, "�����ظ���Ӻ���");
			}
		}
		
		if(friend_friends == null) {  //ԭ��������
			friendUser.setFriend(user.getId()+"");
		}else {
			friendUser.setFriend(friendUser.getFriend()+","+user.getId());
		}
		userMapper.updateByPrimaryKey(friendUser);
		
		
		return SocialResult.ok(friendname);
	}

	//��ѯ�������󣬷���name����
	public SocialResult getFriendsRequest(String username) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if(list.isEmpty())
			return SocialResult.build(400, "���ȵ�¼");
		User user = list.get(0);
		String[] name = null;
		if(user.getFriendRequest() != null && !"".equals(user.getFriendRequest())) {  //�����������Ϊ��
			String[] id = user.getFriendRequest().split(",");
			name = new String[id.length];
			for(int i = 0; i < id.length; ++i) {
				name[i] = getNameById(Integer.valueOf(id[i]));
			}
		}
		return SocialResult.ok(name);
	}

	public SocialResult rejectAddFriend(String username, String friendname) {
		//����username����
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if(list.isEmpty()) {
			return SocialResult.build(400, "�û�����ע��");
		}
		User user = list.get(0);
		
		//����friendname����
		UserExample example1 = new UserExample();
		Criteria criteria1 = example1.createCriteria();
		criteria1.andNameEqualTo(friendname);
		List<User> friendList = userMapper.selectByExample(example1);
		if(friendList.isEmpty()) {
			return SocialResult.build(400, "��ë�����������");
		}
		int friendId = friendList.get(0).getId();
		
		//ɾ��
		String FriendRequset = user.getFriendRequest();
		if(!FriendRequset.contains(friendId+"")) {
			return SocialResult.build(400, "��ë���������");
		}
		

		if (user.getFriendRequest().indexOf(friendId + "") == 0 && !user.getFriendRequest().contains(",")) {
			// ˵��ֻ��һ������
			FriendRequset = user.getFriendRequest().replace(friendId + "", ""); // ���ܺ��µĺ�������
		} else if (user.getFriendRequest().indexOf(friendId + "") == 0) {
			// ˵���ǵ�һ������,�Ҳ�ֹһ������
			FriendRequset = user.getFriendRequest().replace(friendId + ",", ""); // ���ܺ��µĺ�������
		} else {
			FriendRequset = user.getFriendRequest().replace("," + friendId, ""); // ���ܺ��µĺ�������
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
