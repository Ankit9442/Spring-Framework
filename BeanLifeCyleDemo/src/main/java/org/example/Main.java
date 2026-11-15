package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        System.out.println("1. IOC Container Starts");
//        System.out.println("2. Configuration Loading");
//        System.out.println("3. Bean Definition Creation");
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        Spring Bean Life Cycle (Singleton Scope)
//        Interview-ready notes
//        1. IOC Container Starts – Spring creates the IoC container (ApplicationContext).
//
//        2. Configuration Loading – Spring reads configuration from Java configuration classes, XML, or component scanning.
//
//        3. Bean Definition Creation – Spring identifies beans and registers their BeanDefinition in the container.
//
//        4. Bean Instantiation – Spring creates bean objects using constructors or factory methods.
//
//        5. Dependency Injection – Spring injects required dependencies through constructor, setter, or field injection.
//
//        6. Aware Interfaces Callbacks – If implemented, Spring calls relevant Aware methods:
//        - BeanNameAware
//                - BeanClassLoaderAware
//                - BeanFactoryAware
//                - ApplicationContextAware
//        7. BeanPostProcessor (Before Initialization) – Spring calls:
//        postProcessBeforeInitialization().
//
//        8. Initialization Callbacks – Spring performs initialization in this order:
//        - @PostConstruct
//        - InitializingBean.afterPropertiesSet()
//                - Custom initMethod
//        9. BeanPostProcessor (After Initialization) – Spring calls:
//        postProcessAfterInitialization().
//
//                Spring may also create a proxy at this stage.
//
//        10. Bean Ready to Use – The singleton bean is ready and available in the IoC container.
//
//        11. Container Shutdown – When the Spring container shuts down, destruction callbacks are triggered.
//
//        12. Destruction Callbacks – Spring performs cleanup in this order:
//        - @PreDestroy
//        - DisposableBean.destroy()
//                - Custom destroyMethod
//        13. Bean Destroyed – Spring completes the bean's destruction lifecycle.

//        Important interview points
//        1. Singleton scope: Spring creates only one managed instance per bean definition per IoC container.
//        2. Lazy initialization: If a singleton bean is marked @Lazy, its creation is generally delayed until requested.
//        3. Prototype vs Singleton: Spring manages the complete lifecycle of singleton beans, but does not automatically invoke destruction callbacks for prototype beans.
//        4. Destruction: Singleton destruction callbacks execute when the application context is closed properly, not necessarily when the JVM terminates unexpectedly.
//        5. BeanPostProcessor: It can modify a bean before and after initialization and is commonly used in Spring features such as AOP.


        context.close();

    }
}