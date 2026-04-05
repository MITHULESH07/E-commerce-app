package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Main entry point for the E-Commerce Order Management System.
 * Run this class to start the Spring Boot application.
 * Access the app at: http://localhost:8080
 */
@SpringBootApplication
public class OrderManagementApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OrderManagementApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderManagementApplication.class, args);
    }
}
