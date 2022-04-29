package com.bruce.springrabbitmq.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>description<p/>
 *
 * @author likun
 * @date： 2022/4/28 16:10
 */
@Configuration
public class TopicMqConfig {

    public static final String EXCHANGE_NAME = "topic-exchange";
    public static final String QUEUE_NAME = "topic-queue";

    @Bean
    public TopicExchange getTopicExchange() {
        return new TopicExchange(EXCHANGE_NAME, true, false);
    }

    @Bean(QUEUE_NAME)
    public Queue getQueue() {
        return new Queue(QUEUE_NAME, true, false, false, null);
    }

    @Bean
    public Binding getBinding(TopicExchange topicExchange, @Qualifier(QUEUE_NAME) Queue queue) {
        return BindingBuilder.bind(queue).to(topicExchange).with("ERROR");
    }
}
