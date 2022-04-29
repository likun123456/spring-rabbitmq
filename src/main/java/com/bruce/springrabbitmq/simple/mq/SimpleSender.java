package com.bruce.springrabbitmq.simple.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>description<p/>
 *
 * @author likun
 * @date： 2022/4/28 13:49
 */
@Component
@Slf4j
public class SimpleSender {

    @Resource
    private RabbitTemplate rabbitTemplate;

    private static final String QUEUE_NAME="simple.hello";

    public void send() {
        String message = "Hello World!";
        rabbitTemplate.convertAndSend(QUEUE_NAME, message);
        log.info(" [x] Sent '{}'", message);
    }
}
