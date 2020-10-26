package com.cc.cloud.service;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: cc
 * @Date: 2020/10/26 0026 18:54
 * @Description:
 */
@FeignClient(value = "cloud-provider-hystrix-payment")
public interface OrderService {

    @RequestMapping(value = "/ok",method = RequestMethod.POST)
    public ResultData ok(Integer id);

    @RequestMapping(value = "/timeOut",method = RequestMethod.POST)
    public ResultData timeOut(Integer id);
}
