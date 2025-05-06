package com.example.OrderProcessingSystem.service;

import com.example.OrderProcessingSystem.model.CustomerOrder;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumerService {

    @JmsListener(destination = "order-queue")
    public void consumeMessage(CustomerOrder message) {
        System.out.println("Consumed message from the message queue: " + message);
    }
}

