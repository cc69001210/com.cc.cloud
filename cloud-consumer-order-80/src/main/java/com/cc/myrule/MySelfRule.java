package com.cc.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: cc
 * @Date: 2020/10/16 0016 15:21
 * @Description:
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule iRule(){
        return new RoundRobinRule();
    }

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        int current = atomicInteger.get();
        int next = (current + 1) % 2;
        boolean b = atomicInteger.compareAndSet(current, next);

        System.out.println(b);
    }
}
