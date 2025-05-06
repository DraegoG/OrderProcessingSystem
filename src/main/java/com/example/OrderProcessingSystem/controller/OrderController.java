package com.example.OrderProcessingSystem.controller;

import com.example.OrderProcessingSystem.model.CustomerOrder;
import com.example.OrderProcessingSystem.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    //using constructor injection
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity processOrder(@RequestBody CustomerOrder customerOrder){
        CustomerOrder customerOrderResponse = orderService.processOrder(customerOrder);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(customerOrderResponse);
    }

    @GetMapping
    public ResponseEntity getAllOrders() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.getAllOrders());
    }
}
