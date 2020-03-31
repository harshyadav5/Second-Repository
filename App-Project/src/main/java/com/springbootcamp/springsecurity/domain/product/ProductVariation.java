package com.springbootcamp.springsecurity.domain.product;


import com.springbootcamp.springsecurity.domain.order.Carts;
import com.springbootcamp.springsecurity.domain.order.OrderProducts;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "PRODUCT_VARIATION")
public class ProductVariation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @NotNull
    private Integer  QUANTITY_AVAILABLE;

    @NotNull
    private Integer PRICE;
    @Size(max = 100)
    private String PRIMARY_IMAGE_NAME;

    @OneToMany(mappedBy = "productVariation",cascade = CascadeType.ALL)
    private List<Carts> cartsList;

    public List<Carts> getCartsList() {
        return cartsList;
    }

    public void setCartsList(List<Carts> cartsList) {
        this.cartsList = cartsList;
    }

    @OneToMany(mappedBy = "productVariation",cascade = CascadeType.ALL)
    private List<OrderProducts> orderProductsList;

    public List<OrderProducts> getOrderProductsList() {
        return orderProductsList;
    }

    public void setOrderProductsList(List<OrderProducts> orderProductsList) {
        this.orderProductsList = orderProductsList;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID",nullable = false)
    private Products product;

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getQUANTITY_AVAILABLE() {
        return QUANTITY_AVAILABLE;
    }

    public void setQUANTITY_AVAILABLE(Integer QUANTITY_AVAILABLE) {
        this.QUANTITY_AVAILABLE = QUANTITY_AVAILABLE;
    }

    public Integer getPRICE() {
        return PRICE;
    }

    public void setPRICE(Integer PRICE) {
        this.PRICE = PRICE;
    }

    public String getPRIMARY_IMAGE_NAME() {
        return PRIMARY_IMAGE_NAME;
    }

    public void setPRIMARY_IMAGE_NAME(String PRIMARY_IMAGE_NAME) {
        this.PRIMARY_IMAGE_NAME = PRIMARY_IMAGE_NAME;
    }
}
