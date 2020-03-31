package com.springbootcamp.springsecurity.domain.user;

import com.springbootcamp.springsecurity.domain.order.Orders;
import com.springbootcamp.springsecurity.domain.product.ProductReviews;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
@PrimaryKeyJoinColumn(name = "USER_ID")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customers extends AppUsers{
    private  String CONTACT;

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

    public String getCONTACT() {
        return CONTACT;
    }

    public void setCONTACT(String CONTACT) {
        this.CONTACT = CONTACT;
    }
}
