package com.springbootcamp.springsecurity;

import com.springbootcamp.springsecurity.domain.Role;
import com.springbootcamp.springsecurity.domain.user.AppUsers;
import com.springbootcamp.springsecurity.repository.AppUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class SpringSecurityApplicationTests {

	@Autowired
	AppUserRepository appUserRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void checkRoles() {
		AppUsers appUsers = appUserRepository.findByEMAIL("harsh.yadav@tothenew.com");
		System.out.println(appUsers);
	}
}
