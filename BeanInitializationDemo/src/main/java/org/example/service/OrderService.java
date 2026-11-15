package org.example.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class OrderService {

    private final PaymentService paymentService;

    public OrderService( @Lazy PaymentService paymentService){
        this.paymentService = paymentService;
        System.out.println("Order Service created : " + this.hashCode());
    }

    public void placeOrder(){

        this.paymentService.pay();

        System.out.println("Order placed.");

    }


    public void getOrderDetails(){
        System.out.println("Order details");
    }

}
