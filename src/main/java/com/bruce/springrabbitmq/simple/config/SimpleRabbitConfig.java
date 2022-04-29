package com.bruce.springrabbitmq.simple.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;

/**
 * <p>description<p/>
 *
 * @author likun
 * @date： 2022/4/28 13:43
 */
@Configuration
public class SimpleRabbitConfig {

    @Bean
    public Queue hello() {
        return new Queue("simple.hello");
    }


}
