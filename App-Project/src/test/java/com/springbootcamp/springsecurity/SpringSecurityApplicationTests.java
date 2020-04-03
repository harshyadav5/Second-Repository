package com.springbootcamp.springsecurity;

import com.springbootcamp.springsecurity.domain.Role;
import com.springbootcamp.springsecurity.domain.user.Customers;
import com.springbootcamp.springsecurity.domain.user.Users;
import com.springbootcamp.springsecurity.repository.CustomerRepository;
import com.springbootcamp.springsecurity.repository.UserRepository;
import com.springbootcamp.springsecurity.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootTest
class SpringSecurityApplicationTests {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	CustomerRepository customerRepository;

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	@Test
	void contextLoads() {
	}

	@Test
	public void addCustomer(){
		Customers registerCustomer = new Customers();

		registerCustomer.setEmail("Ajay.customer@gmail.com");
		registerCustomer.setFirstName("Ajay");
		registerCustomer.setMiddleName("");
		registerCustomer.setPassword(passwordEncoder.encode("password"));
		registerCustomer.setContact("7053872246");
		List<Role> roleList = new ArrayList<>();
//		Role role = new Role();
//		role.setAuthority("ROLE_CUSTOMER");
		roleList.add(roleRepository.findByAuthority("ROLE_CUSTOMER"));
		registerCustomer.setRoleList(roleList);

		customerRepository.save(registerCustomer);
	}
	@Test
	public void findRoleByID(){
		Optional<Role> optional = roleRepository.findById(2);
		Role role = optional.get();
		System.out.println("This is new Role #############################: "+role);
	}
	@Test
	public void findRoleByAuthority(){
		Role role= roleRepository.findByAuthority("ROLE_CUSTOMER");
		System.out.println("New Role is ================ "+role);
	}
//	@Test
//	public void findCustomerById(){
//		Customers customers=customerRepository.findById(12).get();
//		System.out.println(customers.getEmail());
//	}
}
