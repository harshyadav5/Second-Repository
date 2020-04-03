package com.springbootcamp.springsecurity.services;

import com.springbootcamp.springsecurity.dto.CustomerDto;
import com.springbootcamp.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUser(CustomerDto customerDto){
    }
}
