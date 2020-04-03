package com.springbootcamp.springsecurity.domain.order;

import com.springbootcamp.springsecurity.domain.product.ProductVariation;
import com.springbootcamp.springsecurity.domain.user.Customers;

import javax.persistence.*;

@Entity
@Table(name = "CART")
//@PrimaryKeyJoinColumn(name = "CUSTOMER_USER_ID")
public class Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    private boolean isWishList;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_VARIATION_ID",nullable = false)
    private ProductVariation productVariation;

    public ProductVariation getProductVariation() {
        return productVariation;
    }

    public void setProductVariation(ProductVariation productVariation) {
        this.productVariation = productVariation;
    }

    @OneToOne
    @JoinColumn(name = "CUSTOMER_USER_ID")
    private Customers customer;

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isWishList() {
        return isWishList;
    }

    public void setWishList(boolean wishList) {
        isWishList = wishList;
    }
}
