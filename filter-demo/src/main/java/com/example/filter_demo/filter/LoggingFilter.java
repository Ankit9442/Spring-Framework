package com.example.filter_demo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.UUID;

//@Component
//@Order(2)
public class LoggingFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Request Entered Logging Filter.");

        HttpServletRequest httpServletRequest = ( HttpServletRequest)  servletRequest;
        HttpServletResponse httpServletResponse = ( HttpServletResponse)  servletResponse;

        String  requestId = UUID.randomUUID().toString();
        String requestMethod = httpServletRequest.getMethod();

        System.out.println("Request Id : " + requestId + " - Request Method : " + requestMethod ) ;

        httpServletResponse.setHeader("request-id", requestId);

        filterChain.doFilter(servletRequest , servletResponse);

        System.out.println("Request Exit from Logging Filter.");

    }
}
