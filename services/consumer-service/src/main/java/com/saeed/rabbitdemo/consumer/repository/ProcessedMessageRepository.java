package com.saeed.rabbitdemo.consumer.repository;

import com.saeed.rabbitdemo.consumer.entity.ProcessedMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessedMessageRepository extends JpaRepository<ProcessedMessage, Long> {
}
