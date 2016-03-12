package com.yush.entity.components;


public class Email {
    private Integer id;
    private String emailAddress;
    private Integer userId;

    public Email() {
    }

    @Override
    public String toString() {
        return "emailAddress='" + emailAddress;
    }

    public void setId(Integer id) {
        this.id = id;
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
