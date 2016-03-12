package com.yush.entity.components;

public class Phone {
    private Integer id;
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

    public Integer getId() {

        return id;
    }

    @Override
    public String toString() {
        return ("phoneNumber=" + phoneNumber);
    }
}
