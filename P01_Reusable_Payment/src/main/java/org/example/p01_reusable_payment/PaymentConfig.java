package org.example.p01_reusable_payment;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class PaymentConfig {

    @Bean
    @ConditionalOnMissingBean(PaymentService.class)
    public PaymentService getPaymentBean(){
        System.out.println("Payment Auto Configured");
        return new PaymentService();
    }

}
