package com.springbootcamp.springsecurity.dto;

import com.springbootcamp.springsecurity.annotation.PasswordMatcher;

import javax.validation.constraints.NotEmpty;

//@PasswordMatcher
public class ForgotPasswordDto {
    @NotEmpty
    private String password;
    @NotEmpty
    private String confirmPassword;

    public ForgotPasswordDto(){

    }

    public ForgotPasswordDto(@NotEmpty String password, @NotEmpty String confirmPassword) {
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
