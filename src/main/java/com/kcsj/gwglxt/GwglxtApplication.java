package com.kcsj.gwglxt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kcsj.gwglxt.mapper")
public class GwglxtApplication {

    public static void main(String[] args) {
        SpringApplication.run(GwglxtApplication.class, args);
    }
}
