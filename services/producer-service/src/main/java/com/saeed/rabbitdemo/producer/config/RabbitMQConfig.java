package com.saeed.rabbitdemo.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // --- Direct Exchange setup ---
    public static final String QUEUE_1 = "queue.one";
    public static final String QUEUE_2 = "queue.two";
    public static final String DIRECT_EXCHANGE = "direct.exchange";
    public static final String ROUTING_KEY_1 = "key.one";
    public static final String ROUTING_KEY_2 = "key.two";

    // --- Fanout Exchange setup ---
    public static final String FANOUT_EXCHANGE = "fanout.exchange";

    // --- Topic Exchange setup ---
    public static final String TOPIC_EXCHANGE = "topic.exchange";
    public static final String TOPIC_QUEUE_1 = "topic.queue.one";
    public static final String TOPIC_QUEUE_2 = "topic.queue.two";

    @Bean
    public Queue directQueue1() {
        return new Queue(QUEUE_1, false);
    }

    @Bean
    public Queue directQueue2() {
        return new Queue(QUEUE_2, false);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public Binding directBinding1(Queue directQueue1, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with(ROUTING_KEY_1);
    }

    @Bean
    public Binding directBinding2(Queue directQueue2, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with(ROUTING_KEY_2);
    }

    // --- Fanout Exchange ---
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding fanoutBinding1(Queue directQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(directQueue1).to(fanoutExchange);
    }

    @Bean
    public Binding fanoutBindingTwo(Queue directQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(directQueue2).to(fanoutExchange);
    }

    // === Topic Exchange ===
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Queue topicQueue1() {
        return new Queue(TOPIC_QUEUE_1, false);
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue(TOPIC_QUEUE_2, false);
    }

    @Bean
    public Binding topicBindingQueue1(Queue topicQueue1, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with("user.*");
    }

    @Bean
    public Binding topicBinding2(Queue topicQueue2, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with("user.login.#");
    }
}
