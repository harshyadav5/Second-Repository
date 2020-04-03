package com.springbootcamp.springsecurity.services;

import com.springbootcamp.springsecurity.co.SellerCO;
import com.springbootcamp.springsecurity.domain.Role;
import com.springbootcamp.springsecurity.domain.user.Sellers;
import com.springbootcamp.springsecurity.repository.RoleRepository;
import com.springbootcamp.springsecurity.repository.SellerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    RoleRepository roleRepository;

    public void registerSeller(SellerCO sellerCO){
        Sellers registerSeller = new Sellers();
        BeanUtils.copyProperties(sellerCO,registerSeller);
//        Role sellerRole = roleRepository.findByAuthority("ROLE_SELLER");
        List<Role> roleList = new ArrayList<>();
        roleList.add(roleRepository.findByAuthority("ROLE_SELLER"));
        registerSeller.setRoleList(roleList);
        sellerRepository.save(registerSeller);
    }
}
