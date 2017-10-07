package com.sultanongarbayev.userswebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedHashMap;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        LinkedHashMap map;
        SpringApplication.run(Application.class, args);
    }
}
