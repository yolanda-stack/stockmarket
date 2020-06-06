package com.smc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SMCPriceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SMCPriceApplication.class, args);
    }
}