package com.example.rabitmqproject.controller;

import com.example.rabitmqproject.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MassageController {

    private RabbitMQProducer producer;
    public MassageController(RabbitMQProducer producer) {
        this.producer=producer;
    }

    @GetMapping("/publisher")
    public ResponseEntity<String> sendMessage(@RequestParam(value = "message") String message) {
        producer.send(message);
        return ResponseEntity.ok("message sent to RabbitMQ ....");
    }
}
