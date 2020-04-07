package com.springbootcamp.springsecurity.repository;

import com.springbootcamp.springsecurity.domain.token.ForgotPasswordToken;
import org.springframework.data.repository.CrudRepository;

public interface ForgotPasswordTokenRepository extends CrudRepository<ForgotPasswordToken,Long> {
    ForgotPasswordToken findByToken(String token);
}
