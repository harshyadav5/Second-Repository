package com.springbootcamp.springsecurity.domain.product;

import com.springbootcamp.springsecurity.domain.user.Customers;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PRODUCT_REVIEW")
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class ProductReviews extends Products {

    private String review;

    private Double rating;      //Double

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_USER_ID",nullable = false)
    private Customers customer;

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
