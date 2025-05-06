package com.example.OrderProcessingSystem.repository;

import com.example.OrderProcessingSystem.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<CustomerOrder, String> {
}
