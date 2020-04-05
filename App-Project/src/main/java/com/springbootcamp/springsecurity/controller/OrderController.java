package com.springbootcamp.springsecurity.controller;

import com.springbootcamp.springsecurity.dto.OrderDto;
import com.springbootcamp.springsecurity.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public OrderDto getOrderDetails(@PathVariable Integer id){
       return orderService.getOrderProduct(id);
    }

    @GetMapping("/")
    public List<OrderDto> getOrdersList(){
        return orderService.getAllOrderProducts();
    }

    @PostMapping("/")
    public OrderDto addOrder(@RequestBody OrderDto orderDto, WebRequest webRequest){
       return orderService.addNewOrder(orderDto);
    }

    @PutMapping("/")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto,WebRequest webRequest){
        return orderService.updateOrder(orderDto);
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> deleteOrder(@PathVariable Integer id){
        return  orderService.removeOrder(id);
    }
}
