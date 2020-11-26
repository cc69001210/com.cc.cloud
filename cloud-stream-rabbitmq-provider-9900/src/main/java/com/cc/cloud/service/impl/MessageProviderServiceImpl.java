package com.cc.cloud.service.impl;

import com.cc.cloud.service.MessageProviderService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @company: 北京一零科技
 * @program: cloud
 * @author: cc
 * @Date: 2020-11-26 16:23
 * @Description:
 */
@EnableBinding(value = Source.class)
public class MessageProviderServiceImpl implements MessageProviderService {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String message = UUID.randomUUID().toString();
        // 参见官网： https://docs.spring.io/spring-cloud-stream-binder-rabbit/docs/3.0.10.RELEASE/reference/html/spring-cloud-stream-binder-rabbit.html#_using_existing_queuesexchanges
        output.send(MessageBuilder.withPayload(message).build());
        System.out.println("message: " + message);
        return message;
    }
}
