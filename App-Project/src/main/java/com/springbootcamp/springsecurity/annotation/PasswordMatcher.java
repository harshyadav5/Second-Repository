package com.springbootcamp.springsecurity.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatcherValidator.class)
public @interface PasswordMatcher {
    String message() default "Password And Confirm Password Are Not Same";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
