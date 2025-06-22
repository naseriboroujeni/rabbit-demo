package com.saeed.rabbitdemo.consumer.service;

import com.saeed.rabbitdemo.consumer.entity.ProcessedMessage;
import com.saeed.rabbitdemo.consumer.repository.ProcessedMessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final ProcessedMessageRepository processedMessageRepository;

    public MessageService(ProcessedMessageRepository processedMessageRepository) {
        this.processedMessageRepository = processedMessageRepository;
    }

    public ProcessedMessage saveMessage(String message) {
        return processedMessageRepository.save(ProcessedMessage.builder().content(message).build());
    }
}
