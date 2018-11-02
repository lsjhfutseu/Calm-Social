package com.social.commonpojo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.social.pojo.Comment;

public class SimpleThings {
	private String curUsername;
	private String content;
	private String postTime;// 传入时间改为new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(nt.getPosttime())
	private int thingId;
	private List<SimpleComment> ls;  

	
	
	
	public SimpleThings(String curUsername, String content, Date postTime, int thingId, List<SimpleComment> ls) {
		super();
		this.curUsername = curUsername;
		this.content = content;
		this.postTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(postTime);
		this.thingId = thingId;
		this.ls = ls;
	}

	
	public List<SimpleComment> getLs() {
		return ls;
	}

	public void setLs(List<SimpleComment> ls) {
		this.ls = ls;
	}

	public String getCurUsername() {
		return curUsername;
	}

	public void setCurUsername(String curUsername) {
		this.curUsername = curUsername;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostTime() {
		return postTime;
	}

	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

	public int getThingId() {
		return thingId;
	}

	public void setThingId(int thingId) {
		this.thingId = thingId;
	}

}
