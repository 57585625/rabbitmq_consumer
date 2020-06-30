package com.example.demo.consumer;

/**
 * @author zhangyu
 * @className HelloConsumer
 * @description 模型消息接收者
 * @date 2020-05-13 10:00
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloConsumer {

    @RabbitHandler
    public void process(String content){
        System.out.println("接收消息："+content);
    }
}
