package com.social.service;

import java.util.List;

import com.social.commonpojo.SocialResult;
import com.social.pojo.NewThings;

public interface ThingsService {
	
	//�����û�id��ȡ������
	public List getThingsByUserid(int userId);
	public NewThings getThingsByThingsid(int thingsId);
	
	
	public SocialResult deleteThing(String username, int thingsId);

	/*public List inquiryComment(int thingId);  */

	// �����£��޸��±ȽϺ�
	public SocialResult getNewthings(String userName);

	public SocialResult postNewthings(String record, String username);

}
