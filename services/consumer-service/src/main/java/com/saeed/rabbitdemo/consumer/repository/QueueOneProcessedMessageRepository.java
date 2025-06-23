package com.saeed.rabbitdemo.consumer.repository;

import com.saeed.rabbitdemo.consumer.entity.QueueOneProcessedMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueOneProcessedMessageRepository extends JpaRepository<QueueOneProcessedMessage, Long> {
}
