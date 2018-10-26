package com.social.service;

import java.util.List;

import com.social.pojo.NewThings;

public interface ThingsService {
	
	//根据用户id获取新鲜事
	public List getThingsByUserid(int userId);
	
	public void postThings(String record,int userid);
}
