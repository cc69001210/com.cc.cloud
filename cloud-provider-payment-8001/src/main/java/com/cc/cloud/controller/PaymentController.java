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

/**
 * <p>
 *  前端控制器
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

    @RequestMapping(value = "pay",method = RequestMethod.POST)
    @ApiOperation(value = "支付")
    public ResultData pay(@RequestBody Payment payment){
        if (payment == null) {
            return this.failed(ResultCodeEnum.ERROR_BUSINESS_FAIL);
        }
        payment.setServicePort("8001");
        boolean save = paymentService.save(payment);
        if (!save) {
            return this.failed(ResultCodeEnum.ERROR_BUSINESS_FAIL);
        }
        return this.success();
    }

}

