package com.cc.cloud.service.impl;

import com.cc.base.common.service.impl.BaseServiceImpl;
import com.cc.cloud.domain.entity.Payment;
import com.cc.cloud.mapper.PaymentMapper;
import com.cc.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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
    public void timeOut(Integer id) {
        int sleepSeconds = 3;
        try {
            TimeUnit.SECONDS.sleep(sleepSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("线程：{}，执行方法：ok，获取的参数是：{} ，执行时间为： {} 秒",Thread.currentThread().getName(),id, sleepSeconds);
    }
}
