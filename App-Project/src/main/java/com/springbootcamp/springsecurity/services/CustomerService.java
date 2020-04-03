package com.springbootcamp.springsecurity.services;

import com.springbootcamp.springsecurity.Exception.AccountDoesNotExist;
import com.springbootcamp.springsecurity.Exception.CustomerAlreadyExistsException;
import com.springbootcamp.springsecurity.co.CustomerCO;
import com.springbootcamp.springsecurity.domain.Role;
import com.springbootcamp.springsecurity.domain.user.Customers;
import com.springbootcamp.springsecurity.dto.CustomerDto;
import com.springbootcamp.springsecurity.repository.CustomerRepository;
import com.springbootcamp.springsecurity.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RoleRepository roleRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public CustomerDto registerCustomer(CustomerCO customerCO){
        Customers customer = customerRepository.findByEmail(customerCO.getEmail());
        if(customer != null){
            throw new CustomerAlreadyExistsException("Account Already Exist With This Email Id");
        }
        Customers registerCustomer = new Customers();

        registerCustomer.setEmail(customerCO.getEmail());
        registerCustomer.setFirstName(customerCO.getFirstName());
        registerCustomer.setMiddleName(customerCO.getMiddleName());
        registerCustomer.setLastName(customerCO.getLastName());
        registerCustomer.setPassword(passwordEncoder.encode(customerCO.getPassword()));
        registerCustomer.setContact(customerCO.getContact());
        List<Role> roleList = new ArrayList<>();

        roleList.add(roleRepository.findByAuthority("ROLE_CUSTOMER"));
        registerCustomer.setRoleList(roleList);

        customerRepository.save(registerCustomer);

        CustomerDto customerDto = getCustomer(registerCustomer.getId());
        return customerDto;
    }
    public CustomerDto getCustomer(Integer id){

        Optional<Customers> optional = customerRepository.findById(id);
        if(!optional.isPresent()){
            throw new AccountDoesNotExist("Invalid Account Credentials");
        }
        Customers customer = optional.get();
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setEmail(customer.getEmail());
        customerDto.setFirstName(customer.getFirstName());
        if(customer.getMiddleName() != null){
            customerDto.setMiddleName(customer.getMiddleName());
        }
        customerDto.setLastName(customer.getLastName());
        customerDto.setContact(customer.getContact());

        return  customerDto;
    }

    public List<CustomerDto> getAllCustomer(){
        Iterable<Customers> customersList= customerRepository.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();
        customersList.forEach(customers -> customerDtoList.add(new CustomerDto(customers.getId(),customers.getEmail(),
                customers.getFirstName(),
                customers.getMiddleName(),customers.getLastName(),customers.getContact())));
        return customerDtoList;
    }

    public CustomerDto updateCustomer(Integer id,CustomerCO customerCO){

//        Optional<Customers> optional = customerRepository.findById(id);

        if (!customerRepository.findById(id).isPresent()){
            throw new AccountDoesNotExist("Invalid Account Credentials");
        }

//        if(!optional.isPresent()){
//            throw new AccountDoesNotExist("Invalid Account Credentials");
//        }
//
//        Customers customer = optional.get();
        Customers customer = customerRepository.findById(id).get();
            BeanUtils.copyProperties(customerCO, customer);
            customerRepository.save(customer);
        CustomerDto customerDto = getCustomer(customer.getId());
        return customerDto;
    }

    public Map<String,Boolean> deleteCustomer(Integer id){
        Map<String,Boolean> map = new HashMap<>();
        Optional<Customers> optional = customerRepository.findById(id);

        if(!optional.isPresent()){
            map.put("Deleted",false);
        }
        else {
            customerRepository.deleteById(id);
            map.put("Deleted",true);
        }
        return map;
    }
}
