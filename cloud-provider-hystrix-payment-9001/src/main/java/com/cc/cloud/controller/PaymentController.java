package com.cc.cloud.controller;

import com.cc.base.common.controller.BaseController;
import com.cc.base.common.controller.ResultData;
import com.cc.cloud.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: cc
 * @Date: 2020/10/24 11:04
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("payment")
@Api(value = "支付")
public class PaymentController extends BaseController {


    @Autowired
    private PaymentService paymentService;

    @ApiOperation("支付ok")
    @RequestMapping(value = "/ok",method = RequestMethod.POST)
    public ResultData ok(Integer id) {
        paymentService.ok(id);
        return this.success("执行成功！");
    }


    @ApiOperation(value = "支付超时")
    @RequestMapping(value = "/timeOut",method = RequestMethod.POST)
    public ResultData timeOut(Integer id) {
        paymentService.timeOut(id);
        return this.success("执行成功");
    }


}
