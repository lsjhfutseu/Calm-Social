package com.social.commonpojo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleComment {

	private String cmtname; // 评论人
	private String cmttedname; // 被评论人
	private String content;  
	private String postTime;
	

	// 构造
	public SimpleComment(String content, String cmtname, String cmttedname,Date postTime ) {
		this.content = content;
		this.cmtname = cmtname;
		this.cmttedname = cmttedname;
		this.postTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(postTime);
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
