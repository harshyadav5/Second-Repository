package com.springbootcamp.springsecurity.controller;

import com.springbootcamp.springsecurity.co.CustomerCO;
import com.springbootcamp.springsecurity.dto.CustomerDto;
import com.springbootcamp.springsecurity.repository.CustomerRepository;
import com.springbootcamp.springsecurity.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable Integer id){

        return  customerService.getCustomer(id);
    }

    @PostMapping("/")
    public CustomerDto registerCustomer(@RequestBody CustomerCO customerCO, WebRequest webRequest){
        return customerService.registerCustomer(customerCO);
    }

    @PutMapping("/{id}")
    public CustomerDto updateCustomer(@PathVariable Integer id,@RequestBody CustomerCO customerCO , WebRequest webRequest){
        return  customerService.updateCustomer(id,customerCO);
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> deleteCustomer(@PathVariable Integer id){
       return customerService.deleteCustomer(id);
    }

    @GetMapping("/")
    public List<CustomerDto> getAllCustomer(){
        return  customerService.getAllCustomer();
    }

}