package com.springbootcamp.springsecurity.domain.product;


import com.springbootcamp.springsecurity.domain.order.Carts;
import com.springbootcamp.springsecurity.domain.order.OrderProducts;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "PRODUCT_VARIATION")
public class ProductVariation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer  quantityAvailable;

    @NotNull
    private Integer price;
    @Size(max = 100)
    private String primaryImageName;
    private String metadata;;

    @OneToMany(mappedBy = "productVariation",cascade = CascadeType.ALL)
    private List<Carts> cartsList;

    public List<Carts> getCartsList() {
        return cartsList;
    }

    public void setCartsList(List<Carts> cartsList) {
        this.cartsList = cartsList;
    }

    @OneToMany(mappedBy = "productVariation",cascade = CascadeType.ALL)
    private List<OrderProducts> orderProductsList;

    public List<OrderProducts> getOrderProductsList() {
        return orderProductsList;
    }

    public void setOrderProductsList(List<OrderProducts> orderProductsList) {
        this.orderProductsList = orderProductsList;
    }

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public ProductVariation(){

    }

    public ProductVariation(@NotNull Integer quantityAvailable, @NotNull Integer price,
                            @Size(max = 100) String primaryImageName, String metadata) {
        this.quantityAvailable = quantityAvailable;
        this.price = price;
        this.primaryImageName = primaryImageName;
        this.metadata = metadata;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPrimaryImageName() {
        return primaryImageName;
    }

    public void setPrimaryImageName(String primaryImageName) {
        this.primaryImageName = primaryImageName;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}
