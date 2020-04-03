package com.springbootcamp.springsecurity.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class SellerAlreadyExistException extends RuntimeException {
    public SellerAlreadyExistException(String message){
        super(message);
    }
}
