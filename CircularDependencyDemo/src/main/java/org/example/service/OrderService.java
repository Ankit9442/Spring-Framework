package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    @Autowired
    private  PaymentService payment;

//    public OrderService(PaymentService paymentService){
//        this.payment = paymentService;
//    }

    public void placeOrder(){
        payment.makePayment();
        System.out.println("Order is placed");
    }

    public void getOrderDetails(){
        System.out.println("order details.");
    }
}
