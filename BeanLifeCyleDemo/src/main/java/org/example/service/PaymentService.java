package org.example.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component("paymentBean")

public class PaymentService  {

    public PaymentService(){
        System.out.println("Payment Service bean Post processor is created ");;
    }

    @PostConstruct
    public void start(){
        System.out.println("Payment Service initialization callback. ");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Payment Service destruction callback. ");
    }

}
