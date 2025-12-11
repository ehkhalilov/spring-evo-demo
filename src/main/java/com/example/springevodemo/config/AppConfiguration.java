package com.example.springevodemo.config;

import com.example.springevodemo.model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public Customer customer() {
        return new Customer();
    }
}
