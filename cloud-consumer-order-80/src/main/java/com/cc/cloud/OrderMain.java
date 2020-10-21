package com.cc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
//@RibbonClients({@RibbonClient(name = "cloud-payment-service", configuration = MySelfRule.class)})
public class OrderMain {

	public static void main(String[] args) {
		SpringApplication.run(OrderMain.class, args);
	}

}
