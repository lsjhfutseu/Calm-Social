package com.social.service;

import java.util.List;

public interface ThingsService {
	
	//根据用户id获取新鲜事
	public List getThingsByUserid(int userId);
}
