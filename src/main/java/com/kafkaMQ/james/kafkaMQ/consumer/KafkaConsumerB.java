package com.kafkaMQ.james.kafkaMQ.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerB {

    @KafkaListener(topics = "demo-topic", groupId = "group-b")
    public void listenB(String message) {
        System.out.println("Consumer B nhận: " + message);
    }
}
