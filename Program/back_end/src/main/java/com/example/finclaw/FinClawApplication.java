package com.example.finclaw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FinClawApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinClawApplication.class, args);
    }

}
