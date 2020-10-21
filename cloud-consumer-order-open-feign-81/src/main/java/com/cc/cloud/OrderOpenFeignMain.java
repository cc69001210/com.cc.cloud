package com.cc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.loadbalancer.blocking.client.BlockingLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
//@EnableDiscoveryClient
@RibbonClients({@RibbonClient(name = "cloud-payment-service", configuration = BlockingLoadBalancerClient.class)})
public class OrderOpenFeignMain {

	public static void main(String[] args) {
		SpringApplication.run(OrderOpenFeignMain.class, args);
	}

}
