package com.springbootcamp.springsecurity.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDetails extends RuntimeException{
    public InvalidDetails(String message){
        super(message);
    }
}
