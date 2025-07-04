package com.kafkaMQ.james.kafkaMQ.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafKaConfig {
    @Bean
    public NewTopic createPartitionedTopic() {
        return TopicBuilder.name("load-balanced-topic")
                .partitions(3)
                .replicas(1)
                .build();
    }

}
