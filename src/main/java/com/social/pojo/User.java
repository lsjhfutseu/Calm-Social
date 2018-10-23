package com.social.pojo;

public class User {
    private Integer id;

    private String name;

    private String password;

    private String friend;

    private String things;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend == null ? null : friend.trim();
    }

    public String getThings() {
        return things;
    }

    public void setThings(String things) {
        this.things = things == null ? null : things.trim();
    }
}