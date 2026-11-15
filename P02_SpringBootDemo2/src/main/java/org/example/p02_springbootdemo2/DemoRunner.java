package org.example.p02_springbootdemo2;

import org.example.p02_springbootdemo2.service.PaymentService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner  implements ApplicationRunner {

    private final PaymentService paymentService;

    public DemoRunner(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        paymentService.printPayment();
    }
}
