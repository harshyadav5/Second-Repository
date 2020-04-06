package com.springbootcamp.springsecurity.repository;

import com.springbootcamp.springsecurity.domain.order.Carts;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Carts,Long>{
}
