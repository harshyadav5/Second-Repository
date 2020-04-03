package com.springbootcamp.springsecurity.Security;

import com.springbootcamp.springsecurity.domain.Role;
import com.springbootcamp.springsecurity.domain.user.Users;
import com.springbootcamp.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersDao {
    @Autowired
    UserRepository userRepository;

    public AppUser loadUserByUsername(String username) {
        Users user = userRepository.findByEmail(username);
        List<GrantAuthorityImpl> grantAuthorityList = new ArrayList<>();
        List<Role> roleList = user.getRoleList();

        roleList.forEach(role ->
        {grantAuthorityList.add(new GrantAuthorityImpl(role.getAuthority()));
        }
        );
        if (username != null) {
            return  new AppUser(user.getEmail(),
                    user.getPassword(),
                    grantAuthorityList);
        }
        else {
            throw new RuntimeException();
        }

    }

}
