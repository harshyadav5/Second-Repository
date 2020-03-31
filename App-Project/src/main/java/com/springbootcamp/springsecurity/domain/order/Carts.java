package com.springbootcamp.springsecurity.domain.order;

import com.springbootcamp.springsecurity.domain.product.ProductVariation;
import com.springbootcamp.springsecurity.domain.user.Customers;

import javax.persistence.*;

@Entity
@Table(name = "CART")
@PrimaryKeyJoinColumn(name = "CUSTOMER_USER_ID")
public class Carts extends Customers {

    private Integer QUANTITY;
    private boolean IS_WISH_LIST;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_VARIATION_ID",nullable = false)
    private ProductVariation productVariation;

    public ProductVariation getProductVariation() {
        return productVariation;
    }

    public void setProductVariation(ProductVariation productVariation) {
        this.productVariation = productVariation;
    }

    public Integer getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(Integer QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public boolean isIS_WISH_LIST() {
        return IS_WISH_LIST;
    }

    public void setIS_WISH_LIST(boolean IS_WISH_LIST) {
        this.IS_WISH_LIST = IS_WISH_LIST;
    }
}
