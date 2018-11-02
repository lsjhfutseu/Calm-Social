package com.social.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.commonpojo.SocialResult;
import com.social.commonpojo.SimpleThings;
import com.social.commonpojo.JsonUtils;
import com.social.commonpojo.SimpleComment;
import com.social.mapper.NewThingsMapper;
import com.social.pojo.Comment;
import com.social.pojo.CommentExample;
import com.social.pojo.NewThings;
import com.social.pojo.NewThingsExample;
import com.social.pojo.NewThingsExample.Criteria;
import com.social.pojo.User;
import com.social.service.ThingsService;
import com.social.service.UserService;
import com.social.service.CommentService;

@Service
public class ThingsServiceImpl implements ThingsService {

	@Autowired
	NewThingsMapper newThingsMapper;
	@Autowired
	UserService userService;
	@Autowired
	CommentService commentService;
	
	
	
	public List<NewThings> getThingsByUserid(int userId) {

		NewThingsExample example = new NewThingsExample();

		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		List<NewThings> list = newThingsMapper.selectByExample(example);
		// System.out.println(list.size());

		return list;
	}
	
	/**
	 * 删除新鲜事    //评论未变
	 */
	public SocialResult deleteThing(String username, int id) {
		// 校验是否为当前用户的新鲜事
		int curUserId = userService.getIdbyName(username);
		NewThingsExample example = new NewThingsExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<NewThings> list = newThingsMapper.selectByExample(example);
		if (!list.isEmpty()) {
			NewThings newThings = list.get(0);
			if (newThings.getUserid() == curUserId) {
				try {
					newThingsMapper.deleteByPrimaryKey(id);
					return SocialResult.ok("删除成功");
				} catch (Exception e) {
					return SocialResult.build(400, "删除失败");
				}
			}
		}
		return SocialResult.build(400, "该动态已删除");
	}

	/**
	 * 获取自己和朋友的所有新鲜事，及旗下评论
	 */
	public SocialResult getNewthings(String userName) {
		User user;
		try {
			user = userService.getUserbyName(userName);
		} catch (Exception e) {
			e.printStackTrace();
			return SocialResult.build(400, "无此用户");
		}

		int userId = user.getId();
		String[] allId;
		if(!"".equals(user.getFriend()) && user.getFriend() != null)
		{
			allId = (userId + "," + user.getFriend()).split(",");// userId和friendId
		}
		else {
			allId = new String[1];
			allId[0] = userId + "";
		}
		
		
		TreeMap<Integer, SimpleThings> thingsmap = new TreeMap<Integer, SimpleThings>();
		
		//针对每一个用户id查询newthings及其comment
		for (int i = 0; i < allId.length; i++) {
			int curId = Integer.valueOf(allId[i]);
			String curIdName = userService.getNameById(curId);//此id的人名
			
			NewThingsExample example = new NewThingsExample();
			Criteria criteria = example.createCriteria();
			criteria.andUseridEqualTo(curId);
			List<NewThings> list = newThingsMapper.selectByExample(example);
			//对于每一个newthings查询comment
			for(int j=0;j<list.size();j++) {
				NewThings curthings = list.get(j);
				int curthingsId = curthings.getId();
				
				List<SimpleComment>  ls = commentService.inquiryComment(curthingsId);
				 
				SimpleThings smthings = new SimpleThings(curIdName, curthings.getContent(), curthings.getPosttime(), curthings.getId(), ls);

				thingsmap.put(curthingsId, smthings);
			}
		}
		
		int num = thingsmap.size();
		
		SimpleThings[] res = new SimpleThings[num];
		
		//自然排序--递增
		Set<Integer> set = thingsmap.keySet();
		for (Integer key : set) {
			SimpleThings value = thingsmap.get(key);
			res[num-1]=value;
			num--;
		}
		String temp = JsonUtils.objectToJson(res);
		return SocialResult.ok(temp);
		
	
	}
	

	/**
	 * 发表新鲜事
	 */
	public SocialResult postNewthings(String record, String userName) {
		int userId= userService.getIdbyName(userName);
		
		NewThings newthings = new NewThings();
		newthings.setContent(record);
		newthings.setUserid(userId);
		try {
			newThingsMapper.insert(newthings);
		} catch (Exception e) {
			
			e.printStackTrace();
			return SocialResult.build(400, "插入新鲜事错误");
		}
		
		return SocialResult.ok();
	}

	
	

}
