package com.social.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.commonpojo.SocialResult;
import com.social.mapper.CommentMapper;
import com.social.pojo.Comment;
import com.social.pojo.CommentExample;
import com.social.pojo.CommentExample.Criteria;
import com.social.service.CommentService;

@Service
public class CommentSericeImpl implements CommentService {

	@Autowired
	CommentMapper commentMapper;

	//根据id查询的commet列表
	public List inquiryComment(int commentId) {
		
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(commentId);
		List<Comment> list = commentMapper.selectByExample(example);
		
		return list;
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
