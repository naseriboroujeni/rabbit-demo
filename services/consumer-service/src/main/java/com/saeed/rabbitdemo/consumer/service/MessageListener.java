package com.saeed.rabbitdemo.consumer.service;

import com.saeed.rabbitdemo.consumer.config.RabbitMQConfig;
import com.saeed.rabbitdemo.consumer.entity.QueueTwoProcessedMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    private final QueueOneMessageService queueOneMessageService;
    private final QueueTwoMessageService queueTwoMessageService;

    public MessageListener(
            QueueOneMessageService queueOneMessageService,
            QueueTwoMessageService queueTwoMessageService) {
        this.queueOneMessageService = queueOneMessageService;
        this.queueTwoMessageService = queueTwoMessageService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_ONE)
    public void listenQueueOne(String message) {
        queueOneMessageService.saveMessage(message);
        System.out.println("Queue one received message: " + message);
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_TWO)
    public void listenQueueTwo(String message) {
        queueTwoMessageService.saveMessage(message);
        System.out.println("Queue two received message: " + message);
    }
}
