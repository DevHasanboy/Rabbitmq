package com.example.rabitmqproject.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routingKey.name}")
    private String routingKey;

    private static  final Logger log= LoggerFactory.getLogger(RabbitMQProducer.class);

    private RabbitTemplate rabbitTemplate;
    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String message) {
       log.info(String.format("Sending Message:%s " , message));
       rabbitTemplate.convertAndSend(exchange, routingKey, message);

    }
}
