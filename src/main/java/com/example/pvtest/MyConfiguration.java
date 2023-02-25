package com.example.pvtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Bean
    public MyProvider pippo1() {
        return new MyCallable();
    }

    @Bean
    public MyProvider pippo2() {
        return new MyCallable();
    }
}
