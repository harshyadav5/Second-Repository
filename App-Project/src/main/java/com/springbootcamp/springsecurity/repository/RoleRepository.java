package com.springbootcamp.springsecurity.repository;

import com.springbootcamp.springsecurity.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long>{
    Role findByAuthority(String authority);
}
