package com.cc.cloud.service;

import com.cc.base.common.controller.ResultData;
import com.cc.cloud.domain.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: cc
 * @Date: 2020/10/21 0021 16:44
 * @Description:
 */
@FeignClient(value = "cloud-payment-service")
public interface StoreClient {

    @RequestMapping(value = "payment/pay", method = RequestMethod.POST)
    public ResultData pay(@RequestBody Payment payment);

    @RequestMapping(value = "payment/timeout", method = RequestMethod.POST)
    public ResultData timeout(@RequestBody Payment payment);
}
