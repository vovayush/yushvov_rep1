package com.yush.entity;

import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order extends SceletonEntity {

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "shipping_date")
    private Timestamp shippingDate;

    @Column(name = "paid")
    private boolean paid;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Timestamp getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Timestamp shippingDate) {
        this.shippingDate = shippingDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date='" + date + '\'' +
                ", shippingDate='" + shippingDate + '\'' +
                ", paid=" + paid +
                ", totalPrice=" + totalPrice +
                ", description='" + description + '\'' +
                '}';
    }
}
