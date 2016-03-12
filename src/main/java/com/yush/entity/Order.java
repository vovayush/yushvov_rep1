package com.yush.entity;

public class Order {
    private Integer id;
    private Integer userId;
    private String date;
    private String shippingDate;
    private boolean paid;
    private Double totalPrice;
    private String description;

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
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
