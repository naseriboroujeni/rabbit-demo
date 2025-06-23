package com.saeed.rabbitdemo.consumer.service;

import com.saeed.rabbitdemo.consumer.entity.QueueTwoProcessedMessage;
import com.saeed.rabbitdemo.consumer.repository.QueueTwoProcessedMessageRepository;
import org.springframework.stereotype.Service;

@Service
public class QueueTwoMessageService {

    private final QueueTwoProcessedMessageRepository queueTwoProcessedMessageRepository;

    public QueueTwoMessageService(QueueTwoProcessedMessageRepository queueTwoProcessedMessageRepository) {
        this.queueTwoProcessedMessageRepository = queueTwoProcessedMessageRepository;
    }

    public QueueTwoProcessedMessage saveMessage(String message) {
        return queueTwoProcessedMessageRepository.save(QueueTwoProcessedMessage.builder().content(message).build());
    }
}
