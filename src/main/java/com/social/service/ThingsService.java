package com.social.service;

import java.util.List;

import com.social.pojo.NewThings;

public interface ThingsService {
	
	//�����û�id��ȡ������
	public List getThingsByUserid(int userId);
	
	public void postThings(String record,int userid);
}
