package com.bruce.springrabbitmq.work.config;

import com.bruce.springrabbitmq.work.mq.WorkReceiver;
import com.bruce.springrabbitmq.work.mq.WorkSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>description<p/>
 *
 * @author likun
 * @date： 2022/4/28 14:27
 */
@Configuration
public class WorkRabbitConfig {

    @Bean
    public Queue workQueue() {
        return new Queue("work.hello");
    }

    @Bean
    public WorkReceiver workReceiver1() {
        return new WorkReceiver(1);
    }

    @Bean
    public WorkReceiver workReceiver2() {
        return new WorkReceiver(2);
    }
}
