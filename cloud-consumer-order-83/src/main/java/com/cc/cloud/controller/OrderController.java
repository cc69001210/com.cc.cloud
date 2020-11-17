package com.cc.cloud.controller;

import com.cc.base.common.controller.BaseController;
import com.cc.base.common.controller.ResultData;
import com.cc.cloud.domain.entity.Payment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: cc
 * @Date: 2020/10/14 0014 11:27
 * @Description:
 */
@RequestMapping("order")
@Api("订单")
@RestController
public class OrderController extends BaseController {

    private static final String URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @ApiOperation(value = "创建订单")
    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ResultData createOrder(@RequestBody Payment payment) {
        ResultData resultData = restTemplate.postForObject(URL + "/payment/pay", payment, ResultData.class);
        return resultData;
    }
}
