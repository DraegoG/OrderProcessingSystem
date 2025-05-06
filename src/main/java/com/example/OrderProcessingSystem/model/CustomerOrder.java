package com.example.OrderProcessingSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class CustomerOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String orderId;
    private String item;
    private long quantity;

}
