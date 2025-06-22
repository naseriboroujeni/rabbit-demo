package com.saeed.rabbitdemo.consumer.service;

import com.saeed.rabbitdemo.consumer.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    private final MessageService messageService;

    public MessageListener(MessageService messageService) {
        this.messageService = messageService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void listen(String message) {
        messageService.saveMessage(message);
        System.out.println("Received message: " + message);
    }
}
