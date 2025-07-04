package com.kafkaMQ.james.kafkaMQ.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerA {

    @KafkaListener(topics = "demo-topic", groupId = "group-a")
    public void listenA(String message) {
        System.out.println("Consumer A nhận: " + message);
    }
}