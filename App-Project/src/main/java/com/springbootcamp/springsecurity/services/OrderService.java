package com.springbootcamp.springsecurity.services;

import com.springbootcamp.springsecurity.Exception.InvalidDetails;
import com.springbootcamp.springsecurity.domain.order.Orders;
import com.springbootcamp.springsecurity.dto.OrderDto;
import com.springbootcamp.springsecurity.repository.CartRepository;
import com.springbootcamp.springsecurity.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CartRepository cartRepository;

    public OrderDto getOrderProduct(Integer id){
        Orders order= orderRepository.findById(id).get();
        return new OrderDto(order.getId(),order.getAmountPaid(), order.getDate_created(),order.getPaymentMethod(),
                order.getCustomerAddressAddressLine(),order.getCustomerAddressCity(),order.getCustomerAddressState(),
                order.getCustomerAddressCountry(),order.getCustomerAddressLabel(),order.getCustomerAddressZipCode());
    }

    public List<OrderDto> getAllOrderProducts(){
        Iterable<Orders> orders = orderRepository.findAll();
        List<OrderDto> orderDtoList = new ArrayList<>();
        orders.forEach(orders1 -> orderDtoList.add(new OrderDto(orders1.getId(),orders1.getAmountPaid(),orders1.getDate_created(),
                orders1.getPaymentMethod(),orders1.getCustomerAddressAddressLine(),orders1.getCustomerAddressCity(),
                orders1.getCustomerAddressState(),orders1.getCustomerAddressCountry(),orders1.getCustomerAddressLabel(),
                orders1.getCustomerAddressZipCode())));
        return  orderDtoList;
    }

    public OrderDto addNewOrder(OrderDto orderDto){

        if(!cartRepository.findById(orderDto.getId()).isPresent()){
            throw new InvalidDetails("Item is Not Present In Cart");
        }
        Orders newOrder = new Orders(orderDto.getId(),orderDto.getAmountPaid(),orderDto.getDateCreated(),
                orderDto.getPaymentMethod(),orderDto.getCustomerAddressCity(),orderDto.getCustomerAddressState(),
                orderDto.getCustomerAddressCountry(),orderDto.getCustomerAddressAddressLine(),orderDto.getCustomerAddressZipCode(),
                orderDto.getCustomerAddressLabel());
        orderRepository.save(newOrder);

        return  orderDto;
    }
    public OrderDto updateOrder(OrderDto orderDto){
        if (!orderRepository.findById(orderDto.getId()).isPresent()){
            throw new InvalidDetails("Item Is Not Present In Order");
        }
        Orders updateOrder = orderRepository.findById(orderDto.getId()).get();
        updateOrder.setDate_created(orderDto.getDateCreated());
        updateOrder.setPaymentMethod(orderDto.getPaymentMethod());
        updateOrder.setAmountPaid(orderDto.getAmountPaid());
        updateOrder.setCustomerAddressCity(orderDto.getCustomerAddressCity());
        updateOrder.setCustomerAddressState(orderDto.getCustomerAddressState());
        updateOrder.setCustomerAddressCountry(orderDto.getCustomerAddressCountry());
        updateOrder.setCustomerAddressAddressLine(orderDto.getCustomerAddressAddressLine());
        updateOrder.setCustomerAddressLabel(orderDto.getCustomerAddressLabel());
        updateOrder.setCustomerAddressZipCode(orderDto.getCustomerAddressZipCode());

        orderRepository.save(updateOrder);
        return getOrderProduct(updateOrder.getId());
    }

    public Map<String,Boolean> removeOrder(Integer id){
        Map<String,Boolean> map = new HashMap<>();
        if (!orderRepository.findById(id).isPresent()){
            map.put("Deleted",false);
        }
        else {
            orderRepository.deleteById(id);
            map.put("Deleted",true);
        }
        return map;
    }
}
