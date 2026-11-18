package com.example.filter_demo.filter;

import jakarta.servlet.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

// @Component
//@Order(1)
public class DummyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Request Entered Dummy Filter.");

        filterChain.doFilter(servletRequest , servletResponse);

        System.out.println("Request Exit from Dummy Filter.");


    }
}
