package com.social.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	

}
