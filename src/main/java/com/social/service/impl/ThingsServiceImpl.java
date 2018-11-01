package com.social.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.commonpojo.SocialResult;
import com.social.commonpojo.SimpleComment;
import com.social.mapper.NewThingsMapper;
import com.social.pojo.Comment;
import com.social.pojo.CommentExample;
import com.social.pojo.NewThings;
import com.social.pojo.NewThingsExample;
import com.social.pojo.NewThingsExample.Criteria;
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

	public SocialResult postThings(String record, int userid) {
		NewThings newthings = new NewThings();
		newthings.setContent(record);
		newthings.setUserid(userid);
		try {
			newThingsMapper.insert(newthings);
		} catch (Exception e) {
			
			e.printStackTrace();
			return SocialResult.build(400, "插入新鲜事错误");
		}
		
		return SocialResult.ok();
	}

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

	public List inquiryComment(int thingId) {
		List<Comment> list  = commentService.inquiryComment(thingId);
		if(list.isEmpty()) {
			return null;//SocialResult.build(400, "找不到该新鲜事的评论");
		}
		
		List<SimpleComment> cmtList = new ArrayList<SimpleComment>();
		for (int i = 0; i < list.size(); i++) {
			Comment cur = list.get(i);

			String cmtUserName = userService.getNameById(cur.getCmtuserid());
			String cmttedUserName = userService.getNameById(cur.getCmtuserid());

			SimpleComment simcom = new SimpleComment(cur.getContent(), cmtUserName, cmttedUserName);
			cmtList.add(simcom);
		}
		return cmtList;
		
		
	}

}
