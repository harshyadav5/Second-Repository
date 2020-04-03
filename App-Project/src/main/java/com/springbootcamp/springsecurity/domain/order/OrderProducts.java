package com.springbootcamp.springsecurity.domain.order;

import com.springbootcamp.springsecurity.domain.product.ProductVariation;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_PRODUCT")
public class OrderProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    private Integer price;
    private String productVariationMetadata;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID",nullable = false)
    private Orders orders;

    public Orders getOrders() {
        return orders;
    }
    @ManyToOne
    @JoinColumn(name = "PRODUCT_VARIATION_ID",nullable = false)
    private ProductVariation productVariation;

    public ProductVariation getProductVariation() {
        return productVariation;
    }

    public void setProductVariation(ProductVariation productVariation) {
        this.productVariation = productVariation;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProductVariationMetadata() {
        return productVariationMetadata;
    }

    public void setProductVariationMetadata(String productVariationMetadata) {
        this.productVariationMetadata = productVariationMetadata;
    }
}
