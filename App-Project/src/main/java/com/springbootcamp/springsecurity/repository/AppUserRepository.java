package com.springbootcamp.springsecurity.repository;


import com.springbootcamp.springsecurity.domain.user.AppUsers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppUserRepository extends CrudRepository<AppUsers,Integer> {

    AppUsers findByEMAIL(String email);
    List<Object[]> findByID(Integer id);
}
