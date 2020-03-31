package com.springbootcamp.springsecurity.domain.user;

import com.springbootcamp.springsecurity.domain.product.Products;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SELLERS")
@PrimaryKeyJoinColumn(name = "USER_ID")
public class Sellers extends AppUsers {
    private String GST;
    private String COMPANY_CONTACT;
    private String COMPANY_NAME;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    private List<Products> productsList;

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    public String getGST() {
        return GST;
    }

    public void setGST(String GST) {
        this.GST = GST;
    }

    public String getCOMPANY_CONTACT() {
        return COMPANY_CONTACT;
    }

    public void setCOMPANY_CONTACT(String COMPANY_CONTACT) {
        this.COMPANY_CONTACT = COMPANY_CONTACT;
    }

    public String getCOMPANY_NAME() {
        return COMPANY_NAME;
    }

    public void setCOMPANY_NAME(String COMPANY_NAME) {
        this.COMPANY_NAME = COMPANY_NAME;
    }
}
