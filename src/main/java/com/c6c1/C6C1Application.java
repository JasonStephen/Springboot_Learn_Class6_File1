package com.c6c1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching   //  开启Spring Boot基于注解的缓存管理支持
@SpringBootApplication
public class C6C1Application {

    public static void main(String[] args) {
        SpringApplication.run(C6C1Application.class, args);
    }

}
