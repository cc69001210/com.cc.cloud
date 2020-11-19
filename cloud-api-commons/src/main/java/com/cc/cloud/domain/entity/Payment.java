package com.cc.cloud.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.ToString;

/**
 * <p>
 *
 * </p>
 *
 * @author cc
 * @since 2020-10-13
 */
@TableName("payment")
@Data
@ToString
public class Payment extends Model<Payment> {

    private static final long serialVersionUID = 1L;

    /**
     * 支付流水号
     */
    private String serial;

    private String servicePort;

}
