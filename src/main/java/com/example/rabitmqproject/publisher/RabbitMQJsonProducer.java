package com.example.rabitmqproject.publisher;

import com.example.rabitmqproject.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.jsonKey.name}")
    private String routingJsonKey;

    private static  final Logger log= LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    private RabbitTemplate rabbitTemplate;
    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(User user) {
        log.info(String.format("Sending user: %s", user));
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
    }


}
