package com.springbootcamp.springsecurity.repository;

import com.springbootcamp.springsecurity.domain.user.Sellers;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Sellers,Long> {
    Sellers findByEmail(String string);
}
