package com.bruce.springrabbitmq.work.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>description<p/>
 *
 * @author likun
 * @date： 2022/4/28 14:28
 */
@Component
@Slf4j
public class WorkSender {

    private static final String queueName = "work.hello";

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(int index) {
        StringBuilder builder = new StringBuilder("Hello");
        int limitIndex = index % 3+1;
        for (int i = 0; i < limitIndex; i++) {
            builder.append('.');
        }
        builder.append(index+1);
        String message = builder.toString();
        log.info("send message: {}", message);
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
