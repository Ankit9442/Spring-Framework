package org.example;

import org.example.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);

        OrderService order2  = context.getBean(OrderService.class);
        OrderService order3  = context.getBean(OrderService.class);

        if(order == order2){
            System.out.println("One Instance of Order Service is generated because of singleton scope");
        }else{

            System.out.println("Multiple Instance of Order Service is generated because of prototype scope");
        }


        order.updateBill(100);

        order2.updateBill(200);

        order3.updateBill(300);




    }
}