package com.example.rabitmqproject.controller;

import com.example.rabitmqproject.dto.User;
import com.example.rabitmqproject.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/json")
public class MessageJsonController {

    private RabbitMQJsonProducer rabbitMQJsonProducer;
    public MessageJsonController(RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }

    @PostMapping("/publisher/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        rabbitMQJsonProducer.send(user);
        return ResponseEntity.ok("Json message send to RabbitMQ ...");
    }
}
