package com.bruce.springrabbitmq;

import com.bruce.springrabbitmq.topic.config.TopicMqConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringRabbitmqApplicationTests {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        // TOPIC
        rabbitTemplate.convertAndSend(TopicMqConfig.EXCHANGE_NAME, "ERROR", "error");
    }

}
