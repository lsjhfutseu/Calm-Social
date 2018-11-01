package com.social.service;

import java.util.List;

import com.social.commonpojo.SocialResult;
import com.social.pojo.NewThings;

public interface ThingsService {
	
	//�����û�id��ȡ������
	public List getThingsByUserid(int userId);
	
	public void postThings(String record,int userid);
	
	public SocialResult deleteThing(String username, int id);

	public List inquiryComment(int thingId);  
}
