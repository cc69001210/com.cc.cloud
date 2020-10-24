package com.cc.cloud.controller;

import com.cc.base.common.controller.BaseController;
import com.cc.base.common.controller.ResultData;
import com.cc.cloud.domain.entity.Payment;
import com.cc.cloud.service.StoreClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: cc
 * @Date: 2020/10/14 0014 11:27
 * @Description:
 */
@RequestMapping("order")
@Api("订单")
@RestController
public class OrderController extends BaseController {

    @Autowired
    private StoreClient storeClient;


    @ApiOperation(value = "创建订单")
    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ResultData createOrder(@RequestBody Payment payment) {
        ResultData resultData = storeClient.pay(payment);
        return resultData;
    }


    @ApiOperation(value = "创建订单超时")
    @RequestMapping(value = "payTimeout",method = RequestMethod.POST)
    public ResultData payTimeout(@RequestBody Payment payment) {
        ResultData resultData = storeClient.timeout(payment);
        return resultData;
    }
}
