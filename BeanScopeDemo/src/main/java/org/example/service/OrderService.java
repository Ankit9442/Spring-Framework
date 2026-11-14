package org.example.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class OrderService {

    private int totalBill = 0;
    public OrderService(){
        System.out.println(this.hashCode());
    }

    public void placeOrder(){
        System.out.println("Order Place ");
    }

    public void  updateBill(int val){

        this.totalBill += val;

        System.out.println("Bill Total : " + this.totalBill);
    }

    public int getTotalBill() {
        return totalBill;
    }
}
