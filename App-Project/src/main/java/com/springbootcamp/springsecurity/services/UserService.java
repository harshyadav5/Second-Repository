package com.springbootcamp.springsecurity.services;

import com.springbootcamp.springsecurity.domain.user.Users;
import com.springbootcamp.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String changeActivationStatusOfUser(Integer id){
        Users user= userRepository.findById(id).get();
        if (user.getActive() == true){
            user.setActive(false);
        }
        else {
            user.setActive(true);
        }
        userRepository.save(user);
        return "Activation Status Is Changed";
    }
    public String changeRoleOfUser(Integer id,String role){
        Users user= userRepository.findById(id).get();
        user.getRoleList().get(0).setAuthority(role);
        userRepository.save(user);
        return "User Role Is Changed";
    }
}
