package com.springbootcamp.springsecurity.dto;

public class CartDto {
    private Long cartProductId;
    private Long customerId;
    private Integer quantity;
    private boolean isWishList;
    private Long productVariationId;

    public CartDto(){

    }
    public CartDto(Long cartProductId, Integer quantity, boolean wishList, Long customerId, Long productVariationId) {
        this.cartProductId=cartProductId;
        this.quantity=quantity;
        this.isWishList=wishList;
        this.customerId=customerId;
        this.productVariationId=productVariationId;
    }

    public Long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(Long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setProductVariationId(Long productVariationId) {
        this.productVariationId = productVariationId;
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

    public Long getProductVariationId() {
        return productVariationId;
    }
}
