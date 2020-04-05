package com.springbootcamp.springsecurity.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springbootcamp.springsecurity.domain.user.Sellers;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
@Inheritance(strategy = InheritanceType.JOINED)
public class Products implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    private String description;

    private boolean isCancellable;
    private boolean isReturnable;

    @Size(max = 25)
    @NotNull
    private String brand;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductVariation> productVariationList;

    public List<ProductVariation> getProductVariationList() {
        return productVariationList;
    }

    public void setProductVariationList(List<ProductVariation> productVariationList) {
        this.productVariationList = productVariationList;
    }

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductReviews> productReviewsList;

    public List<ProductReviews> getProductReviewsList() {
        return productReviewsList;
    }

    public void setProductReviewsList(List<ProductReviews> productReviewsList) {
        this.productReviewsList = productReviewsList;
    }

    @ManyToOne
    @JoinColumn(name = "seller_user_id")
    private Sellers seller;

    public Sellers getSeller() {
        return seller;
    }

    public void setSeller(Sellers seller) {
        this.seller = seller;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCancellable() {
        return isCancellable;
    }

    public void setCancellable(boolean cancellable) {
        isCancellable = cancellable;
    }

    public boolean isReturnable() {
        return isReturnable;
    }

    public void setReturnable(boolean returnable) {
        isReturnable = returnable;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
