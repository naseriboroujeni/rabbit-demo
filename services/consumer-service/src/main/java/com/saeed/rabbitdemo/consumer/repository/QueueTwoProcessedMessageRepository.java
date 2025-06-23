package com.saeed.rabbitdemo.consumer.repository;

import com.saeed.rabbitdemo.consumer.entity.QueueOneProcessedMessage;
import com.saeed.rabbitdemo.consumer.entity.QueueTwoProcessedMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueTwoProcessedMessageRepository extends JpaRepository<QueueTwoProcessedMessage, Long> {
}
