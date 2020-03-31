package com.springbootcamp.springsecurity.domain.order;

import com.springbootcamp.springsecurity.domain.product.ProductVariation;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_PRODUCT")
public class OrderProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private Integer QUANTITY;
    private Integer PRICE;
    private String PRODUCT_VARIATION_METADATA;

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

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(Integer QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public Integer getPRICE() {
        return PRICE;
    }

    public void setPRICE(Integer PRICE) {
        this.PRICE = PRICE;
    }

    public String getPRODUCT_VARIATION_METADATA() {
        return PRODUCT_VARIATION_METADATA;
    }

    public void setPRODUCT_VARIATION_METADATA(String PRODUCT_VARIATION_METADATA) {
        this.PRODUCT_VARIATION_METADATA = PRODUCT_VARIATION_METADATA;
    }
}
