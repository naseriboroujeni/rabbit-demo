package com.saeed.rabbitdemo.producer.controller;

import com.saeed.rabbitdemo.producer.service.MessageProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageProducerService messageProducerService;

    public MessageController(MessageProducerService messageProducerService) {
        this.messageProducerService = messageProducerService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message, @RequestParam(required = false, defaultValue = "0") int queueNumber) {
        messageProducerService.sendMessage(message, queueNumber);
        return "Message sent: " + message;
    }
}
