package com.springbootcamp.springsecurity.repository;


import com.springbootcamp.springsecurity.domain.user.Users;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<Users,Long> {

    Users findByEmail(String email);

}
