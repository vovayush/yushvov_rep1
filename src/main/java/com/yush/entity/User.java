package com.yush.entity;

import com.yush.entity.components.Email;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User extends SceletonEntity {

    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "login")
    private String login;
    @Column(name = "passw")
    private String password;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Email.class)
    @JoinColumn(name = "user_id", nullable = false)

    protected Set<Email> userEmails = new HashSet<Email>();

    public Set<Email> getEmails() {
        return userEmails;
    }
    public void setEmails(Set<Email> userEmails) {
        this.userEmails = userEmails;
    }

    public User() {

    }

    public User(String firstName, String lastName, String login, String password, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.description = description;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return this.login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

   /* public Collection<Email> getEmails() {
        return emails;
    }

    public void setEmails(Collection<Email> emails) {
        this.emails = emails;
    }
   */ @Override
    public String toString() {
        return (firstName + " " + lastName);
    }
}
