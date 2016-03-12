package com.yush.entity;


public class Receipt {
    private Integer id;
    private Integer proguctId;
    private Integer orderId;
    private Integer quantity;
    private Double price;
    private Double totalPrice;

    public Integer getId() {
        return id;
    }

    public Integer getProguctId() {
        return proguctId;
    }

    public void setProguctId(Integer proguctId) {
        this.proguctId = proguctId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "proguctId=" + proguctId +
                ", orderId=" + orderId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
