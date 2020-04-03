package com.springbootcamp.springsecurity.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AccountDoesNotExist extends RuntimeException {
    public AccountDoesNotExist(String message){
        super(message);
    }
}
