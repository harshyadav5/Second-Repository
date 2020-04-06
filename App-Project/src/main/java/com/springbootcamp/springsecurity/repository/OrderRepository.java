package com.springbootcamp.springsecurity.repository;

import com.springbootcamp.springsecurity.domain.order.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders,Long> {
}
