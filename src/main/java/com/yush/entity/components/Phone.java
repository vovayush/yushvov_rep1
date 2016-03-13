package com.yush.entity.components;

import com.yush.entity.Identity;

public class Phone implements Identity {
    private long id;
    private String phoneNumber;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Phone() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getID() {

        return id;
    }

    @Override
    public String toString() {
        return ("phoneNumber=" + phoneNumber);
    }
}
