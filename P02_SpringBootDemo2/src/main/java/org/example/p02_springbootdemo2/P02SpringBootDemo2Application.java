package org.example.p02_springbootdemo2;

import org.example.p02_springbootdemo2.service.PaymentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class P02SpringBootDemo2Application {

    public static void main(String[] args) {

          SpringApplication.run(P02SpringBootDemo2Application.class, args);
//        ApplicationContext ccontext = SpringApplication.run(P02SpringBootDemo2Application.class, args);

//        PaymentService payment =  ccontext.getBean(PaymentService.class);
//
//        payment.setPaymentMethod("UPI");
//        payment.setRetryCount(5);
//
//        payment.printPayment();
    }

}
