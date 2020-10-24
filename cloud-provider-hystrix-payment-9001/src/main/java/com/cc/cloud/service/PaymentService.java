package com.cc.cloud.service;

import com.cc.base.common.service.BaseService;
import com.cc.cloud.domain.entity.Payment;

/**
 * @author: cc
 * @Date: 2020/10/24 11:04
 * @Description:
 */
public interface PaymentService extends BaseService<Payment> {

    void ok(Integer id);


    void timeOut(Integer id);
}
