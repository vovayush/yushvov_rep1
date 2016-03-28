package com.yush.entity;

import com.yush.entity.components.Email;
import com.yush.util.Constants;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

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
   // protected Set<Email> userEmails = new HashSet<Email>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Email.class)
    /*@JoinTable(name = "emails", joinColumns = {@JoinColumn(
    name = "id", nullable = false)}, inverseJoinColumns = {*/
    @JoinColumn(name = "user_id", nullable = false)/*}
    )*/
    protected Set<Email> userEmails = new HashSet<Email>();

    public Set<Email> getEmails() {
        return userEmails;
    }
    public void setEmails(Set<Email> userEmails) {
        this.userEmails = userEmails;
    }
    /*@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)*/

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
