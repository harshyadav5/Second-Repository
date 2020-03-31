package com.springbootcamp.springsecurity;


import com.springbootcamp.springsecurity.domain.Role;
import com.springbootcamp.springsecurity.domain.user.AppUsers;
import com.springbootcamp.springsecurity.repository.AppUserRepository;
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
    AppUserRepository appUserRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(appUserRepository.count()<1){
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            AppUsers appUser = new AppUsers();
            appUser.setEMAIL("harsh.yadav@tothenew.com");
            appUser.setFIRST_Name("Harsh");
            appUser.setMIDDLE_Name("Kumar");
            appUser.setLAST_Name("Yadav");
            appUser.setPASSWORD(passwordEncoder.encode("savage"));

            List<Role> roleList = new ArrayList<>();
            Role role1 = new Role();
            role1.setAUTHORITY("ADMIN");
            roleList.add(role1);
            Role role2 = new Role();
            role2.setAUTHORITY("USER");
            roleList.add(role2);
            appUser.setRoleList(roleList);

            appUserRepository.save(appUser);

            System.out.println("Total users saved::"+appUserRepository.count());


        }
    }
}
