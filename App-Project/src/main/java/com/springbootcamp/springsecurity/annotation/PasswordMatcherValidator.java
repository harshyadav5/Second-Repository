package com.springbootcamp.springsecurity.annotation;

import com.springbootcamp.springsecurity.co.UserCO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatcherValidator implements ConstraintValidator<PasswordMatcher, Object> {

    @Override
    public void initialize(PasswordMatcher constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        UserCO userCO = (UserCO) value;
        return userCO.getPassword().equals(userCO.getConfirmPassword());
    }
}
