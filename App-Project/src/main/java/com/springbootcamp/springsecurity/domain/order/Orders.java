package com.springbootcamp.springsecurity.domain.order;

import com.springbootcamp.springsecurity.domain.user.Customers;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDER_TABLE")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private Integer AMOUNT_PAID;

    @Temporal(TemporalType.DATE)
    private Date DATE_CREATED;

    private String PAYMENT_METHOD;
    private String CUSTOMER_ADDRESS_CITY;
    private String CUSTOMER_ADDRESS_STATE;
    private String CUSTOMER_ADDRESS_CUSTOMER;
    private String CUSTOMER_ADDRESS_ADDRESS_LINE;
    private Integer CUSTOMER_ADDRESS_ZIP_CODE;
    private String CUSTOMER_ADDRESS_LABEL;

    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
    private List<OrderProducts> orderProductsList;

    public List<OrderProducts> getOrderProductsList() {
        return orderProductsList;
    }

    public void setOrderProductsList(List<OrderProducts> orderProductsList) {
        this.orderProductsList = orderProductsList;
    }

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_USER_ID",nullable = false)
    private Customers customer;

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getAMOUNT_PAID() {
        return AMOUNT_PAID;
    }

    public void setAMOUNT_PAID(Integer AMOUNT_PAID) {
        this.AMOUNT_PAID = AMOUNT_PAID;
    }

    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    public void setDATE_CREATED(Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }

    public String getPAYMENT_METHOD() {
        return PAYMENT_METHOD;
    }

    public void setPAYMENT_METHOD(String PAYMENT_METHOD) {
        this.PAYMENT_METHOD = PAYMENT_METHOD;
    }

    public String getCUSTOMER_ADDRESS_CITY() {
        return CUSTOMER_ADDRESS_CITY;
    }

    public void setCUSTOMER_ADDRESS_CITY(String CUSTOMER_ADDRESS_CITY) {
        this.CUSTOMER_ADDRESS_CITY = CUSTOMER_ADDRESS_CITY;
    }

    public String getCUSTOMER_ADDRESS_STATE() {
        return CUSTOMER_ADDRESS_STATE;
    }

    public void setCUSTOMER_ADDRESS_STATE(String CUSTOMER_ADDRESS_STATE) {
        this.CUSTOMER_ADDRESS_STATE = CUSTOMER_ADDRESS_STATE;
    }

    public String getCUSTOMER_ADDRESS_CUSTOMER() {
        return CUSTOMER_ADDRESS_CUSTOMER;
    }

    public void setCUSTOMER_ADDRESS_CUSTOMER(String CUSTOMER_ADDRESS_CUSTOMER) {
        this.CUSTOMER_ADDRESS_CUSTOMER = CUSTOMER_ADDRESS_CUSTOMER;
    }

    public String getCUSTOMER_ADDRESS_ADDRESS_LINE() {
        return CUSTOMER_ADDRESS_ADDRESS_LINE;
    }

    public void setCUSTOMER_ADDRESS_ADDRESS_LINE(String CUSTOMER_ADDRESS_ADDRESS_LINE) {
        this.CUSTOMER_ADDRESS_ADDRESS_LINE = CUSTOMER_ADDRESS_ADDRESS_LINE;
    }

    public Integer getCUSTOMER_ADDRESS_ZIP_CODE() {
        return CUSTOMER_ADDRESS_ZIP_CODE;
    }

    public void setCUSTOMER_ADDRESS_ZIP_CODE(Integer CUSTOMER_ADDRESS_ZIP_CODE) {
        this.CUSTOMER_ADDRESS_ZIP_CODE = CUSTOMER_ADDRESS_ZIP_CODE;
    }

    public String getCUSTOMER_ADDRESS_LABEL() {
        return CUSTOMER_ADDRESS_LABEL;
    }

    public void setCUSTOMER_ADDRESS_LABEL(String CUSTOMER_ADDRESS_LABEL) {
        this.CUSTOMER_ADDRESS_LABEL = CUSTOMER_ADDRESS_LABEL;
    }
}
