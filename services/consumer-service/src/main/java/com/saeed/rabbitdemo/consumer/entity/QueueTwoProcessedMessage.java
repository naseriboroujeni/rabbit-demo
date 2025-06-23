package com.saeed.rabbitdemo.consumer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "queue_two_processed_messages")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class QueueTwoProcessedMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
}
