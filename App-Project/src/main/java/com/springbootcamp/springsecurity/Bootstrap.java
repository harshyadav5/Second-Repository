package com.springbootcamp.springsecurity;


import com.springbootcamp.springsecurity.domain.Role;
import com.springbootcamp.springsecurity.domain.order.Carts;
import com.springbootcamp.springsecurity.domain.order.Orders;
import com.springbootcamp.springsecurity.domain.product.Categories;
import com.springbootcamp.springsecurity.domain.product.ProductReviews;
import com.springbootcamp.springsecurity.domain.product.ProductVariation;
import com.springbootcamp.springsecurity.domain.product.Products;
import com.springbootcamp.springsecurity.domain.user.Customers;
import com.springbootcamp.springsecurity.domain.user.Sellers;
import com.springbootcamp.springsecurity.domain.user.Users;
import com.springbootcamp.springsecurity.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductVariationRepository productVariationRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(userRepository.count()<1){
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            Role roleAdmin = new Role((long) 1,"ROLE_ADMIN");
            roleRepository.save(roleAdmin);
            Role roleSeller = new Role((long) 2,"ROLE_SELLER");
            roleRepository.save(roleSeller);
            Role roleCustomer = new Role((long) 3,"ROLE_CUSTOMER");
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
        if(categoryRepository.count() < 1){
            Categories category = new Categories();
            category.setName("Mobile Phones");
            categoryRepository.save(category);
        }
        if(productRepository.count() < 1){
            Products product = new Products();
            product.setName("One Plus 7");
            product.setDescription("Smart Phone");

            product.setCategory(categoryRepository.findByName("Mobile Phones"));
            product.setSeller( sellerRepository.findByEmail("Kshitiz.seller@gmail.com"));

            product.setCancellable(true);
            product.setReturnable(true);
            product.setBrand("OnePlus");
            product.setActive(true);

            List<ProductVariation> productVariations = new ArrayList<>();
            ProductVariation variation1 = new ProductVariation(4,12000,"Image Name",
                    "Meta_Data");
            variation1.setProduct(product);
            productVariations.add(variation1);
            ProductVariation variation2 = new ProductVariation(10,10000,"Second Image Name",
                    "Second Meta Data");
            variation2.setProduct(product);
            productVariations.add(variation2);
            product.setProductVariationList(productVariations);

            List<ProductReviews> productReviewsList = new ArrayList<>();

            ProductReviews review1 = new ProductReviews();
            review1.setReview("Nice Camera");
            review1.setRating(4.8);
            review1.setProduct(product);
            productReviewsList.add(review1);

            ProductReviews review2 = new ProductReviews();
            review2.setReview("Good Battery Backup");
            review2.setRating(4.7);
            review2.setProduct(product);
            productReviewsList.add(review2);
            product.setProductReviewsList(productReviewsList);

            productRepository.save(product);
        }
        if (cartRepository.count() < 1){
            Carts cart = new Carts();
            cart.setProductVariation(productVariationRepository.findById((long) 1).get());
            cart.setCustomer(customerRepository.findById((long) 3).get());
            cart.setWishList(true);
            cart.setQuantity(2);
            cartRepository.save(cart);
        }
        if (orderRepository .count() < 1){
            Orders order = new Orders();
            order.setAmountPaid(10000);
            Date date = new Date();

            order.setDate_created(date);
            order.setPaymentMethod("Debit card");
            order.setCustomerAddressCity("Greater Noida");
            order.setCustomerAddressState("Delhi");
            order.setCustomerAddressCountry("India");
            order.setCustomerAddressAddressLine("Street line 1");
            order.setCustomerAddressLabel("Home");
            order.setCustomerAddressZipCode(201308);

            orderRepository.save(order);
        }
    }
}
