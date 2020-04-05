package com.springbootcamp.springsecurity.controller;

import com.springbootcamp.springsecurity.dto.DepthProductDto;
import com.springbootcamp.springsecurity.dto.ProductDto;
import com.springbootcamp.springsecurity.repository.ProductRepository;
import com.springbootcamp.springsecurity.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @GetMapping("/depth/{id}")
    public DepthProductDto getProductDetails(@PathVariable Integer id){

        return productService.getDepthProduct(id);
    }
    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Integer id){
        return productService.getProduct(id);
    }

    @GetMapping("/")
    public List<ProductDto> getProductList(){

        return productService.getProductList();
    }


}
