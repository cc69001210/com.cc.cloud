package com.cc.cloud.controller;

import com.cc.base.common.controller.BaseController;
import com.cc.base.common.controller.ResultData;
import com.cc.cloud.domain.entity.Payment;
import com.cc.cloud.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class OrderController extends BaseController {


    @Autowired
    private OrderService orderService;


    @ApiOperation(value = "创建订单")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResultData createOrder(@RequestBody Payment payment) {
        return orderService.ok(11);
    }


    @ApiOperation(value = "创建订单")
    @RequestMapping(value = "outTime", method = RequestMethod.POST)
    public ResultData outTime(@RequestBody Payment payment) {
        log.info("进入方法");
        return orderService.timeOut(12);
    }

}
