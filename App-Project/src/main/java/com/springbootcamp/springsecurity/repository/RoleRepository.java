package com.springbootcamp.springsecurity.repository;

import com.springbootcamp.springsecurity.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Integer>{
    Role findByAuthority(String authority);
}
