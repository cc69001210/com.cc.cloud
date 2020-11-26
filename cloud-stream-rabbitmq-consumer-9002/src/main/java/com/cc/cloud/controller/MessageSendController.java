package com.cc.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @company: 北京一零科技
 * @program: cloud
 * @author: cc
 * @Date: 2020-11-26 16:30
 * @Description:
 */
@Component
@Slf4j
@EnableBinding(Sink.class)
public class MessageSendController {

    @Value("${server.port}")
    private Integer serverPort;

    @StreamListener(value = Sink.INPUT)
    public void receive(Message<String> message) {
        log.info("接收到的message信息为：{},接收到消息的微服务端口号是：{}", message.getPayload(), serverPort);
    }

}
