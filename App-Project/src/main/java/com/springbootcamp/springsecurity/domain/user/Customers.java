package com.springbootcamp.springsecurity.domain.user;

import com.springbootcamp.springsecurity.domain.order.Carts;
import com.springbootcamp.springsecurity.domain.order.Orders;
import com.springbootcamp.springsecurity.domain.product.ProductReviews;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
@PrimaryKeyJoinColumn(name = "USER_ID")
//@Inheritance(strategy = InheritanceType.JOINED)    //cart table inherits customer table
public class Customers extends Users{
    private  String contact;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<ProductReviews> productReviewsList;

    public List<ProductReviews> getProductReviewsList() {
        return productReviewsList;
    }

    public void setProductReviewsList(List<ProductReviews> productReviewsList) {
        this.productReviewsList = productReviewsList;
    }

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Orders> ordersList;

    public List<Orders> getOrdersList() {
        return ordersList;
    }
    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }


    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Carts cart;

    public Carts getCart() {
        return cart;
    }

    public void setCart(Carts cart) {
        this.cart = cart;
    }


    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
