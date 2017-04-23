package com.yush.entity;

import javax.persistence.*;

import com.yush.entity.components.Characteristic;
import com.yush.entity.components.PrComment;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")

public class Product extends SceletonEntity {

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

   /* @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = PrComment.class)
    @JoinColumn(name = "product_id", nullable = false)*/
   @OneToMany(mappedBy = "productId", fetch = FetchType.EAGER)
    protected Set<PrComment> prComments = new HashSet<PrComment>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Characteristic.class)
    @JoinColumn(name = "product_id", nullable = false)
    protected Set<Characteristic> characteristics = new HashSet<Characteristic>();

    public Product() {
    }

    public Product(String name, String description, Double price, Integer quantity) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Set<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Set<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public Set<PrComment> getPrComments() {
        return prComments;
    }

    public void setPrComments(Set<PrComment> prComments) {
        this.prComments = prComments;
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


    public static void copyProduct(Product productFrom, Product productTo) {
        productTo.setId(productFrom.getID());
        productTo.setName(productFrom.getName());
        productTo.setDescription(productFrom.getDescription());
        productTo.setPrice(productFrom.getPrice());
        productTo.setGroup(productFrom.getGroup());
        productTo.setVendor(productFrom.getVendor());
        productTo.setDetail(productFrom.getDetail());
    }

    @Override
    public String toString() {
        return "product{" +
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

        if (super.getID() != product.getID()) return false;
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
        return (int) (super.getID() ^ (super.getID() >>> 32));
    }
}
