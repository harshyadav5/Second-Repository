package com.springbootcamp.springsecurity.repository;

import com.springbootcamp.springsecurity.domain.product.Categories;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Categories,Long> {

    Categories findByName(String name);
}
