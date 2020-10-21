package com.cc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: cc
 * @Date: 2020/10/13 0013 11:49
 * @Description:
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.cc.cloud.mapper")
public class PaymentMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8003.class, args);
    }
}
