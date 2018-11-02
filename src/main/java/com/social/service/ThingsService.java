package com.social.service;

import java.util.List;

import com.social.commonpojo.SocialResult;
import com.social.pojo.NewThings;

public interface ThingsService {
	
	//根据用户id获取新鲜事
	public List getThingsByUserid(int userId);
	
	public SocialResult postThings(String record,int userid);
	
	public SocialResult deleteThing(String username, int id);

	/*public List inquiryComment(int thingId);  */

	// 新鲜事，修改下比较好
	public SocialResult getNewthings(String userName);

	public SocialResult postNewthings(String record, String username);

}
