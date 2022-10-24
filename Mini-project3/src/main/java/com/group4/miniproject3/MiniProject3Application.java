package com.group4.miniproject3;

import Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniProject3Application {
    public static void main(String[] args) {
        SpringApplication.run(MiniProject3Application.class, args);
        System.out.println("hello");
    }
}