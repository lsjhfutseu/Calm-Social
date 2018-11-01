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
import com.social.service.ThingsService;

@Controller
public class ThingsController {
	@Autowired
	ThingsService thingsService;

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
		return null;
	}

}
