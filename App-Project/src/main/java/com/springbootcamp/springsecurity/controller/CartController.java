package com.springbootcamp.springsecurity.controller;

import com.springbootcamp.springsecurity.dto.CartDto;
import com.springbootcamp.springsecurity.dto.ProductDto;
import com.springbootcamp.springsecurity.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/")
    public ProductDto addToCart(@RequestBody CartDto cartDto, WebRequest webRequest){
        return cartService.addProductToCart(cartDto);
    }
    @GetMapping("/")
    public List<CartDto> getCartObjects(){
       return cartService.getCartProducts();
    }
}

