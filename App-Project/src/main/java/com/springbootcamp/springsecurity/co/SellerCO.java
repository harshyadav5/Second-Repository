package com.springbootcamp.springsecurity.co;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SellerCO extends UserCO {

    @NotEmpty
    private String gst;
    @NotEmpty
    private String companyName;
    @NotEmpty
    private String companyContact;

    public SellerCO(@NotNull @NotEmpty String email, @NotNull @NotEmpty String firstName,
                    String middleName, @NotNull @NotEmpty String lastName, @NotNull @NotEmpty String password,
                    @NotNull @NotEmpty String confirmPassword,@NotNull @NotEmpty String gst, @NotNull @NotEmpty String
                    companyName,@NotNull @NotEmpty  String companyContact) {
        super(email, firstName, middleName, lastName, password, confirmPassword);
        this.gst=gst;
        this.companyName=companyName;
        this.companyContact=companyContact;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }
}
