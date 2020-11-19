package com.cc.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @company: 北京一零科技
 * @program: cloud
 * @author: cc
 * @Date: 2020-11-17 16:50
 * @Description:
 */
//@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("payment_pay", r -> r.path("/payment/pay").uri("http://localhost:8001"))
                .route("payment_timeout", r -> r.path("/payment/timeout").uri("http://localhost:8001"))
                .route("guonei", r -> r.path("/guonei").uri("http://news.baidu.com"))
                .route("guoji", r -> r.path("/guoji").uri("http://news.baidu.com"))
                .build();
    }
}
