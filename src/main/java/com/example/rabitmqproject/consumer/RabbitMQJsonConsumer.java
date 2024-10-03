package com.example.rabitmqproject.consumer;

import com.example.rabitmqproject.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {

    private static final Logger log= LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void jsonConsume(User user){
        log.info(String.format("Consuming user: %s", user.toString()));
    }
}
