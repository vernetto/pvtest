package com.example.pvtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PvtestApplication implements CommandLineRunner {
    @Autowired
    MyProvider pippo1;

    public static void main(String[] args) {
        SpringApplication.run(PvtestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        pippo1.hello();
        ;
        if (1 > 2) {
            System.out.println("pippo");
        }

    }
}
