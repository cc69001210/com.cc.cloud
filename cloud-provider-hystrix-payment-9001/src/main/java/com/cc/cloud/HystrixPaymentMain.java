package com.cc.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.cc.cloud.mapper")
@EnableCircuitBreaker
public class HystrixPaymentMain {

    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentMain.class, args);
    }

}
