package com.efaculte.efaculteapiv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.efaculte.efaculteapiv1")
public class EfaculteApiV1Application {

    public static void main(String[] args) {
        SpringApplication.run(EfaculteApiV1Application.class, args);
    }

}
