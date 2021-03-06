package com.cc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class CloudStreamRabbitmqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitmqConsumerApplication.class, args);
    }

}
