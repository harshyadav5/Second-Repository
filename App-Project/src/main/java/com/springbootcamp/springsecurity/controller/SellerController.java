package com.springbootcamp.springsecurity.controller;

import com.springbootcamp.springsecurity.Exception.SellerAlreadyExistException;
import com.springbootcamp.springsecurity.co.SellerCO;
import com.springbootcamp.springsecurity.domain.user.Sellers;
import com.springbootcamp.springsecurity.dto.ProductDto;
import com.springbootcamp.springsecurity.dto.SellerDto;
import com.springbootcamp.springsecurity.repository.SellerRepository;
import com.springbootcamp.springsecurity.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @GetMapping("/{id}")
    public SellerDto getSeller(@PathVariable Long id){
        return sellerService.getSeller(id);
    }

    @PostMapping("/")
    public SellerDto registerSeller(@RequestBody SellerCO sellerCO, WebRequest webRequest){
       return sellerService.registerSeller(sellerCO);
    }

    @PutMapping("/{id}")
    public SellerDto updateSeller(@PathVariable Long id,@RequestBody SellerCO sellerCO,WebRequest webRequest){
        return sellerService.updateSeller(id,sellerCO);
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> deleteSeller(@PathVariable Long id){
        return sellerService.deleteSeller(id);
    }

    @GetMapping("/")
    public List<SellerDto> getAllSeller(){
       return sellerService.getAllSeller();
    }

    @GetMapping("/product/{id}")
    public List<ProductDto> getAllProductsOfSeller(@PathVariable Long id){
        return sellerService.getAllProductsOfSeller(id);
    }

}
