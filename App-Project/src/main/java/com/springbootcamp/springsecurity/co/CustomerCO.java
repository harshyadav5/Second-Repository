package com.springbootcamp.springsecurity.co;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerCO extends UserCO{

    @NotEmpty
    private String contact;

    public CustomerCO(@NotNull @NotEmpty String email, @NotNull @NotEmpty String firstName, String middleName,
                      @NotNull @NotEmpty String lastName, @NotNull @NotEmpty String password,
                      @NotNull @NotEmpty String confirmPassword,@NotNull  @NotEmpty String contact) {
        super(email, firstName, middleName, lastName, password, confirmPassword);
        this.contact=contact;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
