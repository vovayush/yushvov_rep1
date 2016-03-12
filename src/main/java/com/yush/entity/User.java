package com.yush.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements Identity{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;
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

    public long getID() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


    @Override
    public String toString() {
        return (firstName + " " + lastName);
    }
}
