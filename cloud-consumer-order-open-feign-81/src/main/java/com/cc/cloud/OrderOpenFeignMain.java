package com.cc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
@EnableDiscoveryClient
//@RibbonClient(name = "CLOUD_PAYMENT_SERVICE", configuration = RandomRule.class)
public class OrderOpenFeignMain {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain.class, args);
    }

}
