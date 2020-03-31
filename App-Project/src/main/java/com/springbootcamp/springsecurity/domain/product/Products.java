package com.springbootcamp.springsecurity.domain.product;

import com.springbootcamp.springsecurity.domain.user.Sellers;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
@Inheritance(strategy = InheritanceType.JOINED)
public class Products{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @NotNull
    @Size(max = 50)
    private String NAME;

    @NotNull
    private String DESCRIPTION;

    private boolean IS_CANCELLABLE;
    private boolean IS_RETURNABLE;

    @Size(max = 25)
    @NotNull
    private String BRAND;
    private boolean IS_ACTIVE;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID",nullable = false)
    private Categories productCategory;

    public Categories getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Categories productCategory) {
        this.productCategory = productCategory;
    }

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductVariation> productVariationList;

    public List<ProductVariation> getProductVariationList() {
        return productVariationList;
    }

    public void setProductVariationList(List<ProductVariation> productVariationList) {
        this.productVariationList = productVariationList;
    }


    @ManyToOne
    @JoinColumn(name ="SELLER_USER_ID",nullable = false)
    private Sellers seller;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public boolean isIS_CANCELLABLE() {
        return IS_CANCELLABLE;
    }

    public void setIS_CANCELLABLE(boolean IS_CANCELLABLE) {
        this.IS_CANCELLABLE = IS_CANCELLABLE;
    }

    public boolean isIS_RETURNABLE() {
        return IS_RETURNABLE;
    }

    public void setIS_RETURNABLE(boolean IS_RETURNABLE) {
        this.IS_RETURNABLE = IS_RETURNABLE;
    }

    public String getBRAND() {
        return BRAND;
    }

    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }

    public boolean isIS_ACTIVE() {
        return IS_ACTIVE;
    }

    public void setIS_ACTIVE(boolean IS_ACTIVE) {
        this.IS_ACTIVE = IS_ACTIVE;
    }

    public Sellers getSeller() {
        return seller;
    }

    public void setSeller(Sellers seller) {
        this.seller = seller;
    }
}
