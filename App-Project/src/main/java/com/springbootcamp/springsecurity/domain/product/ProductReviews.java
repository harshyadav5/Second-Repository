package com.springbootcamp.springsecurity.domain.product;

import com.springbootcamp.springsecurity.domain.user.Customers;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PRODUCT_REVIEW")
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class ProductReviews extends Products {

    private String REVIEW;

    @Size(max = 25)
    private String RATING;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_USER_ID",nullable = false)
    private Customers customer;

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public String getREVIEW() {
        return REVIEW;
    }

    public void setREVIEW(String REVIEW) {
        this.REVIEW = REVIEW;
    }

    public String getRATING() {
        return RATING;
    }

    public void setRATING(String RATING) {
        this.RATING = RATING;
    }
}
