package com.springbootcamp.springsecurity.controller;

import com.springbootcamp.springsecurity.domain.Role;
import com.springbootcamp.springsecurity.domain.user.AppUsers;
import com.springbootcamp.springsecurity.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class Controller {
    @Autowired
    AppUserRepository appUserRepository;

    @GetMapping("/getUsers")
    public List<Role> getUsers(){
        AppUsers user =appUserRepository.findByEMAIL("harsh.yadav@tothenew.com");
        AppUsers newUser = new AppUsers();
        newUser.setID(user.getID());
        newUser.setEMAIL(user.getEMAIL());
        newUser.setRoleList(user.getRoleList());
        return user.getRoleList();
    }
}
