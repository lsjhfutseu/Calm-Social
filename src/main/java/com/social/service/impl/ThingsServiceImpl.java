package com.social.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.mapper.NewThingsMapper;
import com.social.pojo.NewThings;
import com.social.pojo.NewThingsExample;
import com.social.pojo.NewThingsExample.Criteria;
import com.social.service.ThingsService;

@Service
public class ThingsServiceImpl implements ThingsService {

	@Autowired
	NewThingsMapper newThingsMapper;
	
	
	public List<NewThings> getThingsByUserid(int userId) {
		
		NewThingsExample example = new NewThingsExample();
		
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		List<NewThings> list = newThingsMapper.selectByExample(example);
		//System.out.println(list.size());
		
		return list;
	}

	public void postThings(String record,int userid) {
			NewThings newthings = new NewThings();
			newthings.setContent(record);
			newthings.setUserid(userid);
	}

	
}
