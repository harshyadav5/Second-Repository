package com.springbootcamp.springsecurity.domain.user;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String CITY;
    private String COUNTRY;
    private String ADDRESS_LINE;
    private String ZIP_CODE;
    private String LABEL;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private AppUsers appUser;

    public AppUsers getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUsers appUser) {
        this.appUser = appUser;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public String getADDRESS_LINE() {
        return ADDRESS_LINE;
    }

    public void setADDRESS_LINE(String ADDRESS_LINE) {
        this.ADDRESS_LINE = ADDRESS_LINE;
    }

    public String getZIP_CODE() {
        return ZIP_CODE;
    }

    public void setZIP_CODE(String ZIP_CODE) {
        this.ZIP_CODE = ZIP_CODE;
    }

    public String getLABEL() {
        return LABEL;
    }

    public void setLABEL(String LABEL) {
        this.LABEL = LABEL;
    }
}
