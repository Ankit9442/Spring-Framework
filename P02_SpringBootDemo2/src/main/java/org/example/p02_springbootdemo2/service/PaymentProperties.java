package org.example.p02_springbootdemo2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("payment")
public class PaymentProperties {

    private String method;
    private int retryCount;

    public String getMethod(){
        return method;
    }

    public int getRetryCount(){
        return retryCount;
    }

    public void setMethod(String method){
        this.method =  method;
    }


    public void setRetryCount(int retryCount){
        this.retryCount =  retryCount;
    }


}
