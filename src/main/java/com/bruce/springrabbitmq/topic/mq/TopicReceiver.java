package com.bruce.springrabbitmq.topic.mq;

import com.bruce.springrabbitmq.topic.config.TopicMqConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * <p>description<p/>
 *
 * @author likun
 * @date： 2022/4/28 16:43
 */
@RabbitListener(queues = TopicMqConfig.QUEUE_NAME)
@Component
public class TopicReceiver {

    @RabbitHandler
    public void getMessage(String msg, Channel channel, Message message) throws IOException {
        System.out.println("接收到消息：" + msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
