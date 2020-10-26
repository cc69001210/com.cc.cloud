package com.cc.cloud.service;

import com.cc.base.common.controller.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: cc
 * @Date: 2020/10/26 0026 18:54
 * @Description:
 */
@FeignClient(value = "cloud-provider-hystrix-payment")
public interface OrderService {

    @RequestMapping(value = "payment/ok",method = RequestMethod.POST)
    ResultData ok(Integer id);

    @RequestMapping(value = "payment`/timeOut",method = RequestMethod.POST)
    ResultData timeOut(Integer id);
}
