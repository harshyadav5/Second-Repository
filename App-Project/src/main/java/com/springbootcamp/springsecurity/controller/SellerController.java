package com.springbootcamp.springsecurity.controller;

import com.springbootcamp.springsecurity.Exception.SellerAlreadyExistException;
import com.springbootcamp.springsecurity.co.SellerCO;
import com.springbootcamp.springsecurity.domain.user.Sellers;
import com.springbootcamp.springsecurity.repository.SellerRepository;
import com.springbootcamp.springsecurity.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/seller")
public class SellerController {

//    @GetMapping("/{email}")
    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    SellerService sellerService;
    @PostMapping("/seller")
    public String registerSeller(@RequestBody SellerCO sellerCO, WebRequest webRequest){
        Sellers seller = sellerRepository.findByEmail(sellerCO.getEmail());
        if (seller != null){
            throw new SellerAlreadyExistException("Account Already Exist With This Email Id");
        }
        else {
            sellerService.registerSeller(sellerCO);
        }
        return "Seller Successfully Registered";
    }
}
