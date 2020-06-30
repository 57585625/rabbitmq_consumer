package com.example.demo.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author zhangyu
 * @className TopicQueue1Consumer
 * @description TODO
 * @date 2020-05-13 16:06
 */
@Component
public class TopicQueue1Consumer {

    @RabbitListener(queues = "topic.queue1")
    public void process(Message message, Channel channel) throws IOException {
        System.out.println("topic.queue1--接收消息："+new String(message.getBody()));
        /***取值为 false 时，表示通知 RabbitMQ 当前消息被确认,如果为 true，则额外将比第一个参数指定的 delivery tag 小的消息一并确认*/
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true); //此行代码是确认接收到了队列的消息
        System.out.println("消费消息确认" + message.getMessageProperties().getConsumerQueue() + "，接收到了回调方法");
    }
}
