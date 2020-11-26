package com.cc.cloud.controller;

import com.cc.cloud.service.MessageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @company: 北京一零科技
 * @program: cloud
 * @author: cc
 * @Date: 2020-11-26 16:30
 * @Description:
 */
@RestController
public class MessageSendController {


    @Autowired
    private MessageProviderService messageProviderService;

    @GetMapping("sendMessage")
    public String sendMessage() {
        String send = messageProviderService.send();
        return send;
    }

}
