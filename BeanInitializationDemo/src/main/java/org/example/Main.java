package org.example;

import org.example.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Order instance is created.");
        OrderService order = context.getBean(OrderService.class);
        System.out.println("Payment instance is not created.");
        order.placeOrder();
        System.out.println("Payment instance is  created.");
    }
}