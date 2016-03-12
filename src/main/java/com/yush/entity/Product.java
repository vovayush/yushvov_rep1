package com.yush.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "products")

public class Product implements Identity{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;
    @Column(name = "p_name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "p_group")
    private String group;
    @Column(name = "vendor")
    private String vendor;
    @Column(name = "detail")
    private String detail;

    public Product() {
    }

    public Product(Integer id, String name, String description, Double price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public long getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getGroup() {
        return group;
    }

    public String getVendor() {
        return vendor;
    }

    public String getDetail() {
        return detail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(String name, String description, Double price, Integer quantity,
                   String group, String vendor, String detail) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.group = group;
        this.vendor = vendor;
        this.detail = detail;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static void copyProduct(Product productFrom, Product productTo) {
        productTo.setId(productFrom.getID());
        productTo.setName(productFrom.getName());
        productTo.setDescription(productFrom.getDescription());
        productTo.setPrice(productFrom.getPrice());
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", group='" + group + '\'' +
                ", vendor='" + vendor + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (!name.equals(product.name)) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (!price.equals(product.price)) return false;
        if (!quantity.equals(product.quantity)) return false;
        if (group != null ? !group.equals(product.group) : product.group != null) return false;
        return !(vendor != null ? !vendor.equals(product.vendor) : product.vendor != null) &&
                !(detail != null ? !detail.equals(product.detail) : product.detail != null);

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
