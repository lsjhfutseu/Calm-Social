package com.social.service;

import java.util.List;

import com.social.commonpojo.SimpleComment;
import com.social.commonpojo.SocialResult;
import com.social.pojo.Comment;

public interface CommentService {
	public List<SimpleComment> inquiryComment(int thingId);
	
	public SocialResult saveComment(String content,int cmtUserId , int thingsId, int cmttedUserId);
	
	public SocialResult deleteComment(int commentId,String userName);
	
	public SocialResult deleteCommentByThingsId(int thingsId,String userName);
}
