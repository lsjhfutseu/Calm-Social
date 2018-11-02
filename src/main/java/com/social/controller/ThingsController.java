package com.social.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.social.commonpojo.CookieUtils;
import com.social.commonpojo.JsonUtils;
import com.social.commonpojo.SocialResult;
import com.social.service.CommentService;
import com.social.service.ThingsService;
import com.social.service.UserService;

@Controller
public class ThingsController {
	@Autowired
	ThingsService thingsService;
	@Autowired
	UserService userService;
	@Autowired
	CommentService commentService;

	/**
	 * 删除新鲜事
	 */
	@RequestMapping("/deleteThing")
	@ResponseBody
	public SocialResult deleteThing(int thingId, HttpServletRequest request, HttpServletResponse response) {

		String username = CookieUtils.getCookieValue(request, "user", true); // true转码

		return thingsService.deleteThing(username, thingId);

	}
	
	/**
	 * saveComment
	 */
	@RequestMapping("/saveComment")
	@ResponseBody
	public SocialResult saveComment(int thingId, String comment/*评论内容*/, Integer becommentedId/*被评论的id*/,
			HttpServletRequest request, HttpServletResponse response) {		
		String userName = CookieUtils.getCookieValue(request, "user", true);
		
		int cmtUserId = -1;
		try {
			cmtUserId = userService.getIdbyName(userName);
		} catch (Exception e) {
			e.printStackTrace();
			return SocialResult.build(400, "请先登录");//???
		}	
		return commentService.saveComment(comment, cmtUserId, thingId, becommentedId);
	}
	
	
	/**
	 *  获取新鲜事，及其评论
	 */
	@RequestMapping("/getnewthings")
	@ResponseBody
	public SocialResult getnewthings(HttpServletRequest request, HttpServletResponse response) {
		//
		String username = CookieUtils.getCookieValue(request, "user", true);// true转码

		return thingsService.getNewthings(username);
	}
	
	/**
	 * 发表新鲜事
	 */
	@RequestMapping("/report")
	@ResponseBody
	public SocialResult postnewthings(String content ,HttpServletRequest request,HttpServletResponse response) {
		
		String username=CookieUtils.getCookieValue(request, "user",true);  //true转码
		
		return thingsService.postNewthings(content,username);
		
	}
	
	/**
	 * 删除评论
	 */
	@RequestMapping("/deleteComment")
	@ResponseBody
	public SocialResult deleteComment(int commentId ,HttpServletRequest request, HttpServletResponse response) {
		String userName=CookieUtils.getCookieValue(request, "user",true);  //true转码
		
		return commentService.deleteComment(commentId, userName);
		
		
	}

}
