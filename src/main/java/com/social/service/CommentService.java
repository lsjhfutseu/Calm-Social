package com.social.service;

import java.util.List;

import com.social.commonpojo.SocialResult;

public interface CommentService {
	public List inquiryComment(int commentId);
	
	public SocialResult saveComment(String content,int cmtUserId , int thingsId, int cmttedUserId);
	
}
