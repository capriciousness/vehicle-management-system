package com.internship.ds;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.internship.ds.dao")
@SpringBootApplication
public class ServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ServletInitializer.class,args);
    }
}
