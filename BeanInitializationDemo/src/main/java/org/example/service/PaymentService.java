package org.example.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class PaymentService {


    private final OrderService orderService;

    public PaymentService(OrderService orderService){
        this.orderService = orderService;
        System.out.println("Payment Service created : " + this.hashCode());
    }

    public void pay(){

        this.orderService.getOrderDetails();
        System.out.println("Payment made.");
    }
}
