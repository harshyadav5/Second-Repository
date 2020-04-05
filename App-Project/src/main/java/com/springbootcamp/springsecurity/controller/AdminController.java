package com.springbootcamp.springsecurity.controller;

import com.springbootcamp.springsecurity.domain.user.Sellers;
import com.springbootcamp.springsecurity.dto.CustomerDto;
import com.springbootcamp.springsecurity.dto.ProductDto;
import com.springbootcamp.springsecurity.dto.SellerDto;
import com.springbootcamp.springsecurity.services.CustomerService;
import com.springbootcamp.springsecurity.services.ProductService;
import com.springbootcamp.springsecurity.services.SellerService;
import com.springbootcamp.springsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    CustomerService customerService;
    @Autowired
    SellerService sellerService;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @GetMapping("/customer")
    public List<CustomerDto> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/seller")
    public List<SellerDto> getAllSeller(){
        return sellerService.getAllSeller();
    }

    @PutMapping("/activationStatus/{id}")
    public String changeStatusOfUser(@PathVariable Integer id){
        return userService.changeActivationStatusOfUser(id);
    }

    @PutMapping("/changeRole/{role}/{id}")
    public String changeRoleOfUser(@PathVariable Integer id,String role){
       return userService.changeRoleOfUser(id,role);
    }

    @GetMapping("/products")
    public List<ProductDto> getAllProducts(){
        return productService.getProductList();
    }
    @PutMapping("/activationStatusOfProduct/{id}")
    public String changeActivationStatusOfProduct(@PathVariable Integer id){
        return productService.changeActivationStatusOfProduct(id);
    }
}
