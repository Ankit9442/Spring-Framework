package com.example.filter_demo.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<DummyFilter> getDummyFilterBean(){
        FilterRegistrationBean<DummyFilter> registrationBeans = new FilterRegistrationBean<>();

        registrationBeans.setFilter(new DummyFilter());

        registrationBeans.setOrder(1);

        registrationBeans.addUrlPatterns("/api/*");

        return registrationBeans;
    }

    @Bean
    public FilterRegistrationBean<LoggingFilter> getLoggingFilterBean(){
        FilterRegistrationBean<LoggingFilter> registrationBeans = new FilterRegistrationBean<>();
        registrationBeans.setFilter(new LoggingFilter());
        registrationBeans.setOrder(2);
        registrationBeans.addUrlPatterns("/api/*");
        return registrationBeans;
    }

}
