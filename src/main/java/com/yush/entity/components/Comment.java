package com.yush.entity.components;


public class Comment {
    private Integer id;
    private String comment;
    private Integer userId;
    private Integer productId;

    public Integer getId() {
        return id;
    }

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
        return "Comment{" +
                "comment='" + comment + '\'' +
                '}';
    }
}
