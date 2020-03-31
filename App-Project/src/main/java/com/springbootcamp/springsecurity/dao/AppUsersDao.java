package com.springbootcamp.springsecurity.dao;

import com.springbootcamp.springsecurity.AppUser;
import com.springbootcamp.springsecurity.GrantAuthorityImpl;
import com.springbootcamp.springsecurity.domain.Role;
import com.springbootcamp.springsecurity.domain.user.AppUsers;
import com.springbootcamp.springsecurity.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppUsersDao {
    @Autowired
    AppUserRepository appUserRepository;

    public AppUser loadUserByUsername(String username) {
        AppUsers user = appUserRepository.findByEMAIL(username);
        List<GrantAuthorityImpl> grantAuthorityList = new ArrayList<>();
        List<Role> roleList = user.getRoleList();

        roleList.forEach(role ->
        {grantAuthorityList.add(new GrantAuthorityImpl(role.getAUTHORITY()));
        }
        );
        if (username != null) {
            return  new AppUser(user.getEMAIL(),
                    user.getPASSWORD(),
                    grantAuthorityList);
        }
        else {
            throw new RuntimeException();
        }

    }

}
