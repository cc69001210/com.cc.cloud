package com.cc.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.cc.base.common.service.impl.BaseServiceImpl;
import com.cc.cloud.domain.entity.Payment;
import com.cc.cloud.mapper.PaymentMapper;
import com.cc.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: cc
 * @Date: 2020/10/24 11:05
 * @Description:
 */
@Service
@Slf4j
public class PaymentServiceImpl extends BaseServiceImpl<PaymentMapper, Payment> implements PaymentService {

    @Override
    public void ok(Integer id) {
        log.info("线程：{}，执行方法：ok，获取的参数是：{} ，执行时间为： {} 秒", Thread.currentThread().getName(), id, 1);
    }

    @Override
    @HystrixCommand(fallbackMethod = "timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public void timeOut(Integer id) {
        int sleepSeconds = 10;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("线程：{}，执行方法：timeOut，获取的参数是：{} ，执行时间为： {} 秒", Thread.currentThread().getName(), id, sleepSeconds);
    }

    public void timeOutHandler(Integer id) {
        log.info("线程：{}，执行方法：ok，获取的参数是：{} ，执行的是： 服务降级方法。", Thread.currentThread().getName(), id);
    }


    // ================== 服务熔断 ==================

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            // 是否开启断路器。
            @HystrixProperty(name = "circuitBreaker.enable", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期，默认为5S
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败率达到多少后熔断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public void paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        log.info("调用成功，流水号为：{}", IdUtil.simpleUUID());
    }


    public void paymentCircuitBreakerFallback(Integer id) {
        log.info("调用降级。");
    }


}
