package com.springbootcamp.springsecurity.repository;

import com.springbootcamp.springsecurity.domain.user.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customers,Long> {
    Customers findByEmail(String email);
}
