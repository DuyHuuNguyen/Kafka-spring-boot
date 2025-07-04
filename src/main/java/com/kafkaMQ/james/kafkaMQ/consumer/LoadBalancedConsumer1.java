package com.kafkaMQ.james.kafkaMQ.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class LoadBalancedConsumer1 {

    @KafkaListener(topics = "load-balanced-topic", groupId = "balanced-group")
    public void consume(String message) {
        System.out.println("✅ Consumer 1 received: " + message);
    }
}
