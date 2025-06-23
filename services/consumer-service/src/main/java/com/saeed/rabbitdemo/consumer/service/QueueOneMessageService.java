package com.saeed.rabbitdemo.consumer.service;

import com.saeed.rabbitdemo.consumer.entity.QueueOneProcessedMessage;
import com.saeed.rabbitdemo.consumer.repository.QueueOneProcessedMessageRepository;
import org.springframework.stereotype.Service;

@Service
public class QueueOneMessageService {

    private final QueueOneProcessedMessageRepository queueOneProcessedMessageRepository;

    public QueueOneMessageService(QueueOneProcessedMessageRepository queueOneProcessedMessageRepository) {
        this.queueOneProcessedMessageRepository = queueOneProcessedMessageRepository;
    }

    public QueueOneProcessedMessage saveMessage(String message) {
        return queueOneProcessedMessageRepository.save(QueueOneProcessedMessage.builder().content(message).build());
    }
}
