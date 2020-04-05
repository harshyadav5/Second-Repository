package com.springbootcamp.springsecurity.repository;

import com.springbootcamp.springsecurity.domain.product.ProductVariation;
import org.springframework.data.repository.CrudRepository;

public interface ProductVariationRepository extends CrudRepository<ProductVariation,Integer> {
}
