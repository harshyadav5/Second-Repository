package com.springbootcamp.springsecurity.controller;

import com.springbootcamp.springsecurity.dto.ForgotPasswordDto;
import com.springbootcamp.springsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getLogin(){
        return "Currently Login";
    }

    @PostMapping("/forgot-password/{email}")
    public String getResetPasswordToken(@PathVariable String email, WebRequest request){
         return userService.forgotPasswordToken(email,request);
    }
    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("token") String token, @Valid @RequestBody ForgotPasswordDto forgotPasswordDto
    ,WebRequest webRequest){
        return userService.resetPassword(token,forgotPasswordDto,webRequest);
    }
}