package com.example.OrderProcessingSystem.service;

import com.example.OrderProcessingSystem.model.CustomerOrder;
import com.example.OrderProcessingSystem.repository.OrderRepository;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private JmsTemplate jmsTemplate;

    //using constructor injection
    public OrderService(OrderRepository orderRepository, JmsTemplate jmsTemplate){
        this.orderRepository = orderRepository;
        this.jmsTemplate = jmsTemplate;
    }

    public CustomerOrder processOrder(CustomerOrder customerOrder){
        //saving to the database
        CustomerOrder order = orderRepository.save(customerOrder);

        //sending to the message queue
        jmsTemplate.convertAndSend("order-queue", order);

        return order;
    }

    public List<CustomerOrder> getAllOrders(){
        return orderRepository.findAll();
    }
}
