package com.springbootcamp.springsecurity.dto;

import java.util.List;

public class DepthProductDto  extends ProductDto{
    private Long id;
    private String productName;
    private String imageName;
    private Integer price;
    private List<String> reviewsList;
    private List<Double> ratingList;
    private String sellerName;
    private String companyContact;
    private String companyName;
    private String gst;

    public DepthProductDto(){

    }

    public DepthProductDto(Long id, String name, String primaryImageName, Integer price,
                           List<String> reviews, List<Double> rating, String firstName, String middleName,
                           String lastName, String companyContact, String companyName, String gst) {

        this.id = id;
        this.productName=name;
        this.imageName=primaryImageName;
        this.price=price;
        this.reviewsList=reviews;
        this.ratingList=rating;
        this.sellerName=firstName+middleName+lastName;
        this.companyContact=companyContact;
        this.companyName=companyName;
        this.gst=gst;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<String> getReviewsList() {
        return reviewsList;
    }

    public void setReviewsList(List<String> reviewsList) {
        this.reviewsList = reviewsList;
    }

    public List<Double> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Double> ratingList) {
        this.ratingList = ratingList;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    @Override
    public String toString() {
        return "DepthProductDto{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", imageName='" + imageName + '\'' +
                ", price=" + price +
                ", reviewsList=" + reviewsList +
                ", ratingList=" + ratingList +
                ", sellerName='" + sellerName + '\'' +
                ", companyContact='" + companyContact + '\'' +
                ", companyName='" + companyName + '\'' +
                ", gst='" + gst + '\'' +
                '}';
    }
}
