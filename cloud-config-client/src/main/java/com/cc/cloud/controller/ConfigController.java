package com.cc.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: cc
 * @Date: 2020/11/24 21:17
 * @Description:
 */
@RestController
public class ConfigController {

    @Value("${config.version}")
    private String configVersion;


    @RequestMapping(value = "/configDev",method = RequestMethod.GET)
    public String getConfig() {
        return configVersion;
    }

}
