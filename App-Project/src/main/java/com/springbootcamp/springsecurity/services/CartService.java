package com.springbootcamp.springsecurity.services;

import com.springbootcamp.springsecurity.domain.order.Carts;
import com.springbootcamp.springsecurity.dto.CartDto;
import com.springbootcamp.springsecurity.dto.ProductDto;
import com.springbootcamp.springsecurity.repository.CartRepository;
import com.springbootcamp.springsecurity.repository.CustomerRepository;
import com.springbootcamp.springsecurity.repository.ProductRepository;
import com.springbootcamp.springsecurity.repository.ProductVariationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductVariationRepository productVariationRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductService productService;

    public ProductDto addProductToCart(CartDto cartDto){
        Carts cart = new Carts();
        cart.setCustomer(customerRepository.findById(cartDto.getCustomerId()).get());
        cart.setProductVariation(productVariationRepository.findById(cartDto.getProductVariationId()).get());
        cart.setQuantity(cartDto.getQuantity());
        cart.setWishList(cartDto.isWishList());
        cartRepository.save(cart);

        ProductDto productDto = productService.getProduct(productVariationRepository.
                findById(cartDto.getProductVariationId()).get().getProduct().getId());
        return productDto;
    }

    public List<CartDto> getCartProducts(){
       Iterable<Carts> carts =cartRepository.findAll();
       List<CartDto> cartDtoList = new ArrayList<>();
       carts.forEach(carts1 -> cartDtoList.add(new CartDto(carts1.getId(),carts1.getQuantity(),carts1.isWishList(),
               carts1.getCustomer().getId(),carts1.getProductVariation().getId())));
       return cartDtoList;
    }
}
