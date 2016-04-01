package com.yush.entity.components;

import com.yush.entity.Identity;
import com.yush.entity.SceletonEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Embeddable
@Entity
@Table(name = "phones")
public class Phone extends SceletonEntity /* implements Identity*/{
   // private long id;
    @Column(name = "phone_number")
    private String phoneNumber;
   /* @Column(name = "user_id")
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
*/
    public Phone() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

   /* public long getID() {

        return id;
    }*/

    @Override
    public String toString() {
        return ("phoneNumber=" + phoneNumber);
    }
}
