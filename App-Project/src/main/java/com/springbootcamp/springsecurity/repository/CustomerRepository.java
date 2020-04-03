package com.springbootcamp.springsecurity.repository;

import com.springbootcamp.springsecurity.domain.user.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customers,Integer> {
    Customers findByEmail(String email);
}
