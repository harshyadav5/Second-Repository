package com.springbootcamp.springsecurity;


import com.springbootcamp.springsecurity.domain.Role;
import com.springbootcamp.springsecurity.domain.user.Customers;
import com.springbootcamp.springsecurity.domain.user.Sellers;
import com.springbootcamp.springsecurity.domain.user.Users;
import com.springbootcamp.springsecurity.repository.UserRepository;
import com.springbootcamp.springsecurity.repository.CustomerRepository;
import com.springbootcamp.springsecurity.repository.RoleRepository;
import com.springbootcamp.springsecurity.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(userRepository.count()<1){
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            Role roleAdmin = new Role(1,"ROLE_ADMIN");
            roleRepository.save(roleAdmin);
            Role roleSeller = new Role(2,"ROLE_SELLER");
            roleRepository.save(roleSeller);
            Role roleCustomer = new Role(3,"ROLE_CUSTOMER");
            roleRepository.save(roleCustomer);

            Users appUser = new Users();
            appUser.setEmail("harsh.yadav@tothenew.com");
            appUser.setFirstName("Harsh");
            appUser.setMiddleName("Kumar");
            appUser.setLastName("Yadav");
            appUser.setPassword(passwordEncoder.encode("savage"));
            appUser.setActive(true);
            appUser.setDeleted(false);

            List<Role> roleList = new ArrayList<>();
            roleList.add(roleAdmin);
            appUser.setRoleList(roleList);

            Sellers seller = new Sellers();
            seller.setEmail("Kshitiz.seller@gmail.com");
            seller.setFirstName("Kshitiz");
            seller.setLastName("Gupta");
            seller.setPassword(passwordEncoder.encode("password"));
            seller.setActive(true);
            seller.setDeleted(false);
            seller.setCompanyContact("Company Contact");
            seller.setCompanyName("Company Name");
            seller.setGst("GST");

            List<Role> sellerRoleList = new ArrayList<>();
            sellerRoleList.add(roleSeller);
            seller.setRoleList(sellerRoleList);

            Customers customer = new Customers();
            customer.setEmail("Smarth.customer@gmail.com");
            customer.setFirstName("Smarth");
            customer.setMiddleName("");
            customer.setLastName("Vaish");
            customer.setPassword(passwordEncoder.encode("password"));
            customer.setActive(true);
            customer.setDeleted(false);
            customer.setContact("Customer Contact");

            List<Role> customerRoleList = new ArrayList<>();
            customerRoleList.add(roleCustomer);
            customer.setRoleList(customerRoleList);

            userRepository.save(appUser);
            sellerRepository.save(seller);
            customerRepository.save(customer);

            System.out.println("Total users saved::"+ userRepository.count());
        }
    }
}
