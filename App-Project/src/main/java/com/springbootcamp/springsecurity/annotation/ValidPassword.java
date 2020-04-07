package com.springbootcamp.springsecurity.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

//@Target(ElementType.TYPE)   //ElementType.ANNOTATION_TYPE

@Target({TYPE,FIELD,ANNOTATION_TYPE})
@Constraint(validatedBy = PasswordCheckValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "Password Format is not valid";
    Class<?> [] groups() default {};
    Class <? extends Payload>[] payload() default {};
}
