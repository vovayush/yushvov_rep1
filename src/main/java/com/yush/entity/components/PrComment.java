package com.yush.entity.components;


import com.yush.entity.Identity;
import com.yush.entity.Product;
import com.yush.entity.SceletonEntity;
import com.yush.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class PrComment extends SceletonEntity {

    @Column(name = "p_comment")
    private String comment;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "product_id")
    private Integer productId;

    @ManyToOne
    @JoinColumn(name="product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private User user;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return comment;
    }
}
