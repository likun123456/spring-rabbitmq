package com.bruce.springrabbitmq.simple.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>description<p/>
 *
 * @author likun
 * @date： 2022/4/28 13:48
 */
@Component
@Slf4j
@RabbitListener(queues = "simple.hello")
public class SimpleReceiver {

    @RabbitHandler
    public void receive(String in) {
        log.info(" [x] Received '{}'", in);
    }
}
