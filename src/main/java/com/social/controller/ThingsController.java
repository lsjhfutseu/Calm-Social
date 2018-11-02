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

		String username = CookieUtils.getCookieValue(request, "user", true); // trueת��

		return thingsService.deleteThing(username, thingId);

	}

	//��ѯ�����µ�����
	@RequestMapping("/inquiryComments")
	@ResponseBody
	public String inquiryThings(Integer thingId) {
		// ����������id������ۣ�תΪ�򵥸�ʽ->json
		System.out.println(thingId);
		List ls = commentService.inquiryComment(thingId);
		String res = JsonUtils.objectToJson(ls);
		return res;
	}
	
	//saveComment
	@RequestMapping("/saveComment")
	@ResponseBody
	public SocialResult saveComment(int thingId, String comment/*��������*/, Integer becommentedId/*�����۵�id*/,
			HttpServletRequest request, HttpServletResponse response) {		
		String userName = CookieUtils.getCookieValue(request, "user", true);
		
		int cmtUserId = -1;
		try {
			cmtUserId = userService.getIdbyName(userName);
		} catch (Exception e) {
			e.printStackTrace();
			return SocialResult.build(400, "���ȵ�¼");//???
		}	
		return commentService.saveComment(comment, cmtUserId, thingId, becommentedId);
	}
	
	
	
	

}
