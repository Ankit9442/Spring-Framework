package org.example.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("orderBean")
public class OrderService implements BeanNameAware , ApplicationContextAware , BeanClassLoaderAware , InitializingBean , DisposableBean {

    private final PaymentService paymentService;

    // Bean instantiation
    // Dependency injection
    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService ;
        System.out.println("4. Order Service Bean Instantiation");
        System.out.println("5. Order Service Dependency Injection");
    }

    // Bean name ware interface
    @Override
    public void setBeanName(String name) {
        System.out.println("Order Service  Bean name : " + name);
    }

    // Bean class loader aware interface
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Order Service  Bean Class Loader : " +  classLoader.getClass());
    }

    // Application context aware interface
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application Context : " + applicationContext.getClass());
    }


    @PostConstruct
    public void initializationCallback(){
        System.out.println("Order Service Initialization Callbacks : PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Order Service Initialization Callbacks : InitializingBean.afterPropertiesSet()");
    }


    @PreDestroy
    public void destroyByPreDestroy()  {

        System.out.println("Order Service Bean Destroyed by PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Order Service Bean Destroyed by DisposableBean.destroy()");

    }
}
