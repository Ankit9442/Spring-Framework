package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    @Autowired
    private  OrderService order;

//    public PaymentService(OrderService orderService){
//        this.order = orderService;
//    }
    public void makePayment(){

        this.order.getOrderDetails();
        System.out.println("Payment is done.");
    }
}
