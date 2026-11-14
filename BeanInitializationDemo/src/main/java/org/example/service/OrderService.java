package org.example.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

public class OrderService {

    private final PaymentService paymentService;

    public OrderService(  PaymentService paymentService){
        this.paymentService = paymentService;
        System.out.println("Order Service created : " + this.hashCode());
    }



}
