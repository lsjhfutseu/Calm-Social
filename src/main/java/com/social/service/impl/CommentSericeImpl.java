package com.social.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.commonpojo.SimpleComment;
import com.social.commonpojo.SocialResult;
import com.social.mapper.CommentMapper;
import com.social.pojo.Comment;
import com.social.pojo.CommentExample;
import com.social.pojo.CommentExample.Criteria;
import com.social.service.CommentService;
import com.social.service.UserService;

@Service
public class CommentSericeImpl implements CommentService {

	@Autowired
	CommentMapper commentMapper;
	@Autowired
	UserService userService;

	//根据thingsId查询的comment列表
	public List<SimpleComment> inquiryComment(int thingId) {
		
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andThingsidEqualTo(thingId);
		List<Comment> list  = commentMapper.selectByExample(example);
		List<SimpleComment> simls = new ArrayList<SimpleComment>();
				
		for(int i=0 ;i<list.size();i++) {
			Comment curcmt = list.get(i);
			String cmtName = userService.getNameById(curcmt.getCmtuserid());
			String cmttedName = userService.getNameById(curcmt.getCmtteduserid());
			SimpleComment simCmt = new SimpleComment(curcmt.getContent(), cmtName, cmttedName, curcmt.getPosttime());
			simls.add(simCmt);
		}
		
		
		
		return simls;
	}

	//插入评论
	public SocialResult saveComment(String content, int cmtUserId, int thingsId, int cmttedUserId) {
		
		Comment cmt = new Comment();
		cmt.setContent(content);
		cmt.setCmtuserid(cmtUserId);
		cmt.setThingsid(thingsId);
		cmt.setCmtteduserid(cmttedUserId);
		
		try {
			commentMapper.insert(cmt);
		} catch (Exception e) {
			e.printStackTrace();
			return SocialResult.build(400, "插入评论错误");
		}

		
		return SocialResult.ok();
	}

	

}
