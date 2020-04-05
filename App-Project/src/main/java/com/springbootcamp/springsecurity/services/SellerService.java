package com.springbootcamp.springsecurity.services;

import com.springbootcamp.springsecurity.Exception.AccountDoesNotExist;
import com.springbootcamp.springsecurity.Exception.SellerAlreadyExistException;
import com.springbootcamp.springsecurity.co.SellerCO;
import com.springbootcamp.springsecurity.domain.Role;
import com.springbootcamp.springsecurity.domain.product.Products;
import com.springbootcamp.springsecurity.domain.user.Sellers;
import com.springbootcamp.springsecurity.dto.ProductDto;
import com.springbootcamp.springsecurity.dto.SellerDto;
import com.springbootcamp.springsecurity.repository.RoleRepository;
import com.springbootcamp.springsecurity.repository.SellerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    RoleRepository roleRepository;

    public SellerDto getSeller(Integer id){
        Sellers seller = sellerRepository.findById(id).get();
        return new SellerDto(seller.getId(),seller.getEmail(),seller.getFirstName(),seller.getMiddleName(),
                seller.getLastName(),seller.getGst(),seller.getCompanyContact(),seller.getCompanyName());
    }

    public SellerDto registerSeller(SellerCO sellerCO){
        Sellers seller = sellerRepository.findByEmail(sellerCO.getEmail());
        if (seller != null){
            throw new SellerAlreadyExistException("Account Already Exist With This Email Id");
        }

        Sellers registerSeller = new Sellers();
        BeanUtils.copyProperties(sellerCO,registerSeller);
        List<Role> roleList = new ArrayList<>();
        roleList.add(roleRepository.findByAuthority("ROLE_SELLER"));
        registerSeller.setRoleList(roleList);
        sellerRepository.save(registerSeller);

        return getSeller(registerSeller.getId());
    }

    public SellerDto updateSeller(Integer id,SellerCO sellerCO){
        if (!sellerRepository.findById(id).isPresent()){
            throw new AccountDoesNotExist("Invalid Account Credentials");
        }
        Sellers seller = sellerRepository.findById(id).get();
        seller.setEmail(sellerCO.getEmail());
        seller.setFirstName(sellerCO.getFirstName());
        seller.setMiddleName(sellerCO.getMiddleName());
        seller.setLastName(sellerCO.getLastName());
        seller.setGst(sellerCO.getGst());
        seller.setCompanyName(sellerCO.getCompanyName());
        seller.setCompanyContact(sellerCO.getCompanyContact());
        sellerRepository.save(seller);

        return getSeller(seller.getId());
    }

    public Map<String,Boolean> deleteSeller(Integer id){
//        if (!sellerRepository.findById(id).isPresent()) {
//            throw new AccountDoesNotExist("Invalid Account Credentials");
//        }
        Map<String,Boolean> map = new HashMap<>();
        if(!sellerRepository.findById(id).isPresent()){
            map.put("Deleted",false);
        }
        else {
            sellerRepository.deleteById(id);
            map.put("Deleted",true);
        }
        return map;
    }

    public List<SellerDto> getAllSeller(){
        Iterable<Sellers> sellers = sellerRepository.findAll();
        List<SellerDto> sellerDtoList = new ArrayList<>();
        sellers.forEach(sellers1 -> sellerDtoList.add(new SellerDto(sellers1.getId(),sellers1.getEmail(),
                sellers1.getFirstName(),sellers1.getMiddleName(),sellers1.getLastName(),sellers1.getGst(),
                sellers1.getCompanyContact(),sellers1.getCompanyName())));
        return sellerDtoList;
    }

    public List<ProductDto> getAllProductsOfSeller(Integer id){
        Sellers seller = sellerRepository.findById(id).get();
        List<ProductDto> productDtoList = new ArrayList<>();
        List<Products> productsList= seller.getProductsList();
        productsList.forEach(product ->productDtoList.add(new ProductDto(product.getId(),product.getName(),
                product.getDescription(),product.isCancellable(),product.isReturnable(),product.getBrand(),
                product.isActive())));
        return productDtoList;
    }
}
