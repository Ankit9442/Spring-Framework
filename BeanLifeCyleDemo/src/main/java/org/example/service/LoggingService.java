package org.example.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LoggingService implements BeanPostProcessor {

    public LoggingService(){
        System.out.println("Logging service have been created.");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println(beanName  + " Bean has instantiated. ");
        System.out.println("Before: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization (Object bean, String beanName) throws BeansException {

        System.out.println("After: " + beanName);
        return bean;
    }
}
