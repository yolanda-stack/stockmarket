package com.smc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients(basePackages = "com.smc.feign") //在客户端开启feign，封装http请求
@SpringBootApplication
public class SMCZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SMCZuulApplication.class, args);
	}
}
