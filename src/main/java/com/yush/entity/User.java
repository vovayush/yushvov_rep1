package com.yush.entity;

import com.yush.entity.components.Address;
import com.yush.entity.components.Email;
import com.yush.entity.components.Phone;
import com.yush.entity.components.PrComment;
import com.yush.util.Constants;

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

    /* @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name = "phones")
    @org.hibernate.annotations.CollectionId(columns = @Column(name = "user_id"),
     type = @org.hibernate.annotations.Type(type = "long"),
           generator =  "native")*/
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Phone.class)
    @JoinColumn(name = "user_id", nullable = false)
    protected Set<Phone> phones = new HashSet<Phone>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Address.class)
    @JoinColumn(name = "user_id", nullable = false)
    protected Set<Address> addresses = new HashSet<Address>();

   /* @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = PrComment.class)
    @JoinColumn(name = "user_id", nullable = false)*/
   @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    protected Set<PrComment> prComments = new HashSet<PrComment>();

    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    protected Set<Order> orders = new HashSet<Order>();

    public User() {

    }

    public User(String firstName, String lastName, String login, String password, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.description = description;

    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public Set<PrComment> getPrComments() {
        return prComments;
    }

    public void setPrComments(Set<PrComment> prComments) {
        this.prComments = prComments;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }


    public Set<Email> getEmails() {
        return userEmails;
    }
    public void setEmails(Set<Email> userEmails) {
        this.userEmails = userEmails;
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


    @Override
    public String toString() {
        return (firstName + " " + lastName);
    }
}
