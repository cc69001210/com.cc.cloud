package com.cc.cloud.service.impl;

import com.cc.base.common.controller.BaseController;
import com.cc.base.common.controller.ResultCodeEnum;
import com.cc.base.common.controller.ResultData;
import com.cc.cloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: cc
 * @Date: 2020/10/28 0028 17:49
 * @Description:
 */
@Component
@Slf4j
@RequestMapping("/fallback")
public class OrderServiceFallback extends BaseController implements OrderService {

    @Override
    public ResultData ok(Integer id) {
        log.warn("方法降级，方法的参数是：{}", id);
        return this.failed(ResultCodeEnum.ERROR_SYSTEM_EXCEPTION,"方法降级。。。");
    }

    @Override
    public ResultData timeOut(Integer id) {
        log.warn("方法降级，方法的参数是：{}", id);
        return this.failed(ResultCodeEnum.ERROR_SYSTEM_EXCEPTION,"方法降级。。。");
    }
}
