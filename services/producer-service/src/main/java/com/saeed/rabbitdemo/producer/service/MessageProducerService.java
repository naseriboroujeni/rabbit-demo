package com.saeed.rabbitdemo.producer.service;

import com.saeed.rabbitdemo.producer.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

    private final RabbitTemplate rabbitTemplate;

    public MessageProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message, int queueNumber) {
        switch (queueNumber) {
            case 1 -> sendMessageToQueueOne(message);
            case 2 -> sendMessageToQueueTwo(message);
            default -> sendMessageFanOut(message);
        }
    }

    private void sendMessageToQueueOne(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, RabbitMQConfig.ROUTING_KEY_1, message);
    }

    private void sendMessageToQueueTwo(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, RabbitMQConfig.ROUTING_KEY_2, message);
    }

    private void sendMessageFanOut(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE, "", message);
    }
}
