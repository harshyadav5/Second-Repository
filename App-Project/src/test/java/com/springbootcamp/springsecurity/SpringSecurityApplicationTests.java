package com.springbootcamp.springsecurity;

import com.springbootcamp.springsecurity.annotation.PasswordMatcher;
import com.springbootcamp.springsecurity.co.UserCO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void checkValidators(){
		UserCO userCO = new UserCO();
		userCO.setEmail("harshyadav@gmail.com");
		userCO.setPassword("password");
		userCO.setConfirmPassword("savage");
		System.out.println(userCO);
	}//bkejhbzvnoiqgvzcs

}
