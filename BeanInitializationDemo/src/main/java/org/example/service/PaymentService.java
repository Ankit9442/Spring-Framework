package org.example.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

public class PaymentService {

    public PaymentService(){
        System.out.println("Payment Service created : " + this.hashCode());
    }
}
