package com.springbootcamp.springsecurity.repository;

import com.springbootcamp.springsecurity.domain.product.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Products,Integer> {
    Products findByName(String name);
}
