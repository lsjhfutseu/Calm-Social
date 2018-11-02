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
import com.social.pojo.NewThings;
import com.social.service.CommentService;
import com.social.service.ThingsService;
import com.social.service.UserService;

@Service
public class CommentSericeImpl implements CommentService {

	@Autowired
	CommentMapper commentMapper;
	@Autowired
	UserService userService;
	@Autowired
	ThingsService thingsService;

	// 根据thingsId查询的comment列表
	public List<SimpleComment> inquiryComment(int thingId) {
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andThingsidEqualTo(thingId);
		List<Comment> list = commentMapper.selectByExample(example);
		List<SimpleComment> simls = new ArrayList<SimpleComment>();

		for (int i = 0; i < list.size(); i++) {
			Comment curcmt = list.get(i);
			String cmtName = userService.getNameById(curcmt.getCmtuserid());
			String cmttedName = userService.getNameById(curcmt.getCmtteduserid());
			SimpleComment simCmt = new SimpleComment(curcmt.getContent(), curcmt.getCmtuserid(), cmtName, cmttedName,
					curcmt.getPosttime());
			simls.add(simCmt);
		}

		return simls;
	}

	/**
	 * 插入评论
	 */
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

	/**
	 * 删除评论:如果登录用户userId为 发表新鲜事的用户 or 发表该评论的用户，则允许删除该comment
	 */
	public SocialResult deleteComment(int commentId, String userName) {
		int userId = userService.getIdbyName(userName);
		// 根据cmtId查到该条cmt
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(commentId);
		List<Comment> list = commentMapper.selectByExample(example);
		if (list.isEmpty()) {
			return SocialResult.build(400, "没查到此条comment");
		}
		Comment cmt = list.get(0);
		int thingsId = cmt.getThingsid();

		NewThings things = thingsService.getThingsByThingsid(thingsId);
		if (things == null) {
			return SocialResult.build(400, "无该新鲜事错误");
		}
		
		int thingsUserId = things.getUserid();

		if (cmt.getCmtuserid() != userId || userId != thingsUserId) {
			return SocialResult.build(400, "没有删除权限");
		}

		commentMapper.deleteByExample(example);
		return SocialResult.ok();
	}

	public SocialResult deleteCommentByThingsId(int thingsId, String userName) {
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andThingsidEqualTo(thingsId);
		
		int userId = userService.getIdbyName(userName);
		int thingsUserId = thingsService.getThingsByThingsid(thingsId).getUserid();
		if(userId != thingsUserId ) {
			return SocialResult.build(400, "无删除权限");
		}
	
		commentMapper.deleteByExample(example);
		
		return SocialResult.ok();
		
		
	}

}
