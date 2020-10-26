package com.cc.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: cc
 * @Date: 2020/10/24 09:27
 * @Description:
 */
@Configuration
public class OpenFeignConfig {

    @Bean
    public Logger.Level getLevel() {
        return Logger.Level.FULL;
    }
}
