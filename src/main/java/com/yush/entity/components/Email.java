package com.yush.entity.components;


import com.yush.entity.Identity;
import com.yush.entity.SceletonEntity;
import com.yush.entity.User;
import com.yush.util.Constants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "emails")
public class Email extends SceletonEntity {

    @Column(name = "email")
    private String emailAddress;

    public Email() {
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return emailAddress;
    }

}
