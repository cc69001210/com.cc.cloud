package com.cc.cloud.service.impl;

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
public class PaymentServiceImpl extends BaseServiceImpl<PaymentMapper,Payment> implements PaymentService {

    @Override
    public void ok(Integer id) {
        log.info("线程：{}，执行方法：ok，获取的参数是：{} ，执行时间为： {} 秒",Thread.currentThread().getName(),id,1);
    }

    @Override
    @HystrixCommand(fallbackMethod = "timeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public void timeOut(Integer id) {
        int sleepSeconds = 10;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("线程：{}，执行方法：ok，获取的参数是：{} ，执行时间为： {} 秒",Thread.currentThread().getName(),id, sleepSeconds);
    }

    public void timeOutHandler(Integer id) {
        log.info("线程：{}，执行方法：ok，获取的参数是：{} ，执行的是： 服务降级方法。",Thread.currentThread().getName(),id);
    }
}
