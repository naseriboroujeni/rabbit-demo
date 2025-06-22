package com.saeed.rabbitdemo.consumer.service;

import com.saeed.rabbitdemo.consumer.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
