package org.example;

import org.example.service.OrderService;
import org.example.service.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        How can you resolve circular dependencies in Spring?
//        "Spring can resolve certain circular dependencies using setter injection or field injection with singleton beans, because Spring can expose an early reference to a bean before its initialization is fully completed. Constructor injection cannot resolve direct circular dependencies. Since Spring Boot 2.6, circular references are disabled by default. The best practice is to redesign the classes to remove the circular dependency."
//        Prefer redesigning the dependency structure rather than relying on field or setter injection to resolve circular dependencies.
//                Important: Since Spring Boot 2.6, circular references are prohibited by default (spring.main.allow-circular-references=false).
//                You can enable them using:
//        spring.main.allow-circular-references=true

        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();
    }
}