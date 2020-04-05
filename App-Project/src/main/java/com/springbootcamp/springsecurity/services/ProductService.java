package com.springbootcamp.springsecurity.services;

import com.springbootcamp.springsecurity.domain.product.ProductReviews;
import com.springbootcamp.springsecurity.domain.product.Products;
import com.springbootcamp.springsecurity.domain.user.Customers;
import com.springbootcamp.springsecurity.dto.CustomerDto;
import com.springbootcamp.springsecurity.dto.DepthProductDto;
import com.springbootcamp.springsecurity.dto.ProductDto;
import com.springbootcamp.springsecurity.dto.SellerDto;
import com.springbootcamp.springsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public DepthProductDto getDepthProduct(Integer id){
        Products product = productRepository.findById(id).get();

        List<ProductReviews> productReviews =product.getProductReviewsList();
        List<String> reviews = new ArrayList<>();
        List<Double> rating = new ArrayList<>();

        productReviews.forEach(productReviews1 -> reviews.add(productReviews1.getReview()));
        productReviews.forEach(productReviews1 -> rating.add(productReviews1.getRating()));
        DepthProductDto depthProductDto = new DepthProductDto(product.getId(),product.getName(),
                product.getProductVariationList().get(id).getPrimaryImageName(),product.getProductVariationList()
                .get(id).getPrice(),reviews,rating, product.getSeller().getFirstName(),product.getSeller().getMiddleName(),
                product.getSeller().getLastName(),
                product.getSeller().getCompanyContact(),product.getSeller().getCompanyName(),
                product.getSeller().getGst());

        return depthProductDto;

    }


    public ProductDto getProduct(Integer id){
        Products product = productRepository.findById(id).get();
        ProductDto productDto = new ProductDto(product.getId(),product.getName(),product.getName(),
                product.isCancellable(),product.isReturnable(),product.getBrand(),product.isActive());
        return productDto;
    }

    public List<ProductDto> getProductList(){
        Iterable<Products> productList=productRepository.findAll();
        List<ProductDto> productDtoList= new ArrayList<>();
        productList.forEach(product -> productDtoList.add(new ProductDto(product.getId(),
                product.getName(),product.getDescription(),product.isCancellable(),product.isReturnable(),
                product.getBrand(),product.isActive())));
        return productDtoList;
    }

    public String changeActivationStatusOfProduct(Integer id){
        Products product = productRepository.findById(id).get();
        if(product.isActive() == true){
            product.setActive(false);
        }
        else {
            product.setActive(true);
        }
        return "Product Status Is Changed";
    }
}
