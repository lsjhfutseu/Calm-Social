package com.social.commonpojo;

public class SimpleComment {
	private String content;
	private String cmtname; // ������
	private String cmttedname; // ��������
	
	//����
	public SimpleComment(String content, String cmtname, String cmttedname) {
		this.content = content;
		this.cmtname = cmtname;
		this.cmttedname = cmttedname;
	}

	//getset
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
