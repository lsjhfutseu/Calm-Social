package com.social.commonpojo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleComment {

	private String cmtname; // 评论人
	private int cmtId; //评论人id
	private String cmttedname; // 被评论人
	private String content;  
	private String postTime;
	

	// 构造
	public SimpleComment(String content, int cmtId, String cmtname, String cmttedname,Date postTime ) {
		this.content = content;
		this.cmtId = cmtId;
		this.cmtname = cmtname;
		this.cmttedname = cmttedname;
		this.postTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(postTime);
	}

	public int getCmtId() {
		return cmtId;
	}

	public void setCmtId(int cmtId) {
		this.cmtId = cmtId;
	}

	public String getPostTime() {
		return postTime;
	}

	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

	// getset
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCmtname() {
		return cmtname;
	}

	public void setCmtname(String cmtname) {
		this.cmtname = cmtname;
	}

	public String getCmttedname() {
		return cmttedname;
	}

	public void setCmttedname(String cmttedname) {
		this.cmttedname = cmttedname;
	}

}
