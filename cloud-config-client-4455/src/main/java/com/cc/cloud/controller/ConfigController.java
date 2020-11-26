package com.cc.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @company: 北京一零科技
 * @program: cloud
 * @author: cc
 * @Date: 2020-11-25 14:21
 * @Description:
 */
@RestController
@RefreshScope
public class ConfigController {

    /**
     * 如果提示失败，那么请检查： 配置文件中yml文件 冒号后面是否加了空格，如果没有加，就会报错。
     */
    @Value("${config.version}")
    private String configVersion;


    @RequestMapping(value = "/configDev", method = RequestMethod.GET)
    public String getConfig() {
        return configVersion;
    }

}
