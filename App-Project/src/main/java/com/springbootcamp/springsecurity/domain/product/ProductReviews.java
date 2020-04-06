package com.springbootcamp.springsecurity.domain.product;

import com.springbootcamp.springsecurity.domain.user.Customers;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PRODUCT_REVIEW")
public class ProductReviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String review;

    private Double rating;      //Double

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_USER_ID",referencedColumnName = "USER_ID")
    private Customers customer;

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName ="id")
    private Products product;

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
