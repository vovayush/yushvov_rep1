package com.yush.entity;

import javax.persistence.*;

@Entity
@Table(name = "receipts")
public class Receipt extends SceletonEntity {
    @Column(name = "product_id")
    private Integer proguctId;
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Double price;
    @Column(name = "total_price")
    private Double totalPrice;
    @ManyToOne
    @JoinColumn(name="product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="order_id", insertable = false, updatable = false)
    private Order order;

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
