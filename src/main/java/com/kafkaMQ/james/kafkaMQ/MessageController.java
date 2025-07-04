package com.kafkaMQ.james.kafkaMQ;

import com.kafkaMQ.james.kafkaMQ.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer producer;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestParam String message) {
        producer.send("demo-topic", message);
        return ResponseEntity.ok("Message sent");
    }

    @PostMapping("/send-multi")
    public ResponseEntity<String> sendMultiple(@RequestParam(defaultValue = "10") int count) {
        for (int i = 1; i <= count; i++) {
            String msg = "Message #" + i;
            producer.send("load-balanced-topic", msg);
        }
        return ResponseEntity.ok("Sent " + count + " messages");
    }
}