package com.cc.cloud.controller;


import com.cc.base.common.controller.BaseController;
import com.cc.base.common.controller.ResultCodeEnum;
import com.cc.base.common.controller.ResultData;
import com.cc.cloud.domain.entity.Payment;
import com.cc.cloud.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cc
 * @since 2020-10-13
 */
@RestController
@RequestMapping("/payment")
@Api(value = "支付")
@Slf4j
public class PaymentController extends BaseController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "pay", method = RequestMethod.POST)
    @ApiOperation(value = "支付")
    public ResultData pay(@RequestBody Payment payment) {
        if (payment == null) {
            return this.failed(ResultCodeEnum.ERROR_BUSINESS_FAIL);
        }
        payment.setServicePort("8003");
        boolean save = paymentService.save(payment);
        if (!save) {
            return this.failed(ResultCodeEnum.ERROR_BUSINESS_FAIL);
        }
        return this.success();
    }

    @ApiOperation(value = "支付")
    @RequestMapping(value = "timeout", method = RequestMethod.POST)
    public ResultData timeout(@RequestBody Payment payment) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {

        }
        return this.success("8003", "成功");
    }


    @ApiOperation(value = "测试")
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        return " 请求接口端口： 8003 ";
    }

}

