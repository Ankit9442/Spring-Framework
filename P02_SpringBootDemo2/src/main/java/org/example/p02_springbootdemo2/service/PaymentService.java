package org.example.p02_springbootdemo2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    private final PaymentProperties paymentProperties;

    public PaymentService(PaymentProperties paymentProperties){
        this.paymentProperties = paymentProperties;
    }


    public String getPaymentMethod(){
        return paymentProperties.getMethod();
    }

    public int getRetryCount(){
        return paymentProperties.getRetryCount();
    }



    public void printPayment(){
        System.out.println("Payment Method : " + paymentProperties.getMethod());
        System.out.println("Retry Count  : " + paymentProperties.getRetryCount());
    }

}
