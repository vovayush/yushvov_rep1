package com.yush.entity.components;


import com.yush.entity.Identity;

public class Email implements Identity{
    private long id;
    private String emailAddress;
    private Integer userId;

    public Email() {
    }

    @Override
    public String toString() {
        return "emailAddress='" + emailAddress;
    }

    public long getID() {
        return id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
