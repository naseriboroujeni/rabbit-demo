package com.saeed.rabbitdemo.consumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_ONE = "queue.one";
    public static final String QUEUE_TWO = "queue.two";
}
