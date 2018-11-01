package com.social.pojo;

import java.util.Date;

public class Comment {
    private Integer id;

    private String content;

    private Integer cmtuserid;

    private Integer thingsid;

    private Integer cmtteduserid;

    private Date posttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getCmtuserid() {
        return cmtuserid;
    }

    public void setCmtuserid(Integer cmtuserid) {
        this.cmtuserid = cmtuserid;
    }

    public Integer getThingsid() {
        return thingsid;
    }

    public void setThingsid(Integer thingsid) {
        this.thingsid = thingsid;
    }

    public Integer getCmtteduserid() {
        return cmtteduserid;
    }

    public void setCmtteduserid(Integer cmtteduserid) {
        this.cmtteduserid = cmtteduserid;
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }
}