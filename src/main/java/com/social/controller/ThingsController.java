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

	@RequestMapping("/deleteThing")
	@ResponseBody
	public SocialResult deleteThing(int thingId, HttpServletRequest request, HttpServletResponse response) {

		String username = CookieUtils.getCookieValue(request, "user", true); // true转码

		return thingsService.deleteThing(username, thingId);

	}

	@RequestMapping("/inquirycomments")
	@ResponseBody
	public String inquiryThings(int thingId) {
		// 根据新鲜事id查出评论，转为简单格式->json
		List ls = thingsService.inquiryComment(thingId);
		String res = JsonUtils.objectToJson(ls);
		return res;
	}
	
	//saveComment
	@RequestMapping("/saveComment")
	@ResponseBody
	public SocialResult saveComment(int thingId, String comment/*评论内容*/, String becommented/*被评论的人名字*/,
			HttpServletRequest request, HttpServletResponse response) {

		System.out.println(""+thingId+"+"+comment+"+"+becommented);
		
		String userName = CookieUtils.getCookieValue(request, "user", true);
		
		int cmtUserId = -1;
		try {
			cmtUserId = userService.getIdbyName(userName);
		} catch (Exception e) {
			e.printStackTrace();
			return SocialResult.build(400, "请先登录");//???
		}
		
		
		int cmttedUserId = -1;
		if (!"".equals(becommented) && becommented != null) {
			cmttedUserId = userService.getIdbyName(becommented);// 任何数据库操作都要捕捉？
		}
		
		
		return commentService.saveComment(comment, cmtUserId, thingId, cmttedUserId);
	}

}
