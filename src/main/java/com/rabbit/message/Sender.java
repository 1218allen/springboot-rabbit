package com.rabbit.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private FanoutExchange exchange;

    public void send(String msgId) {
        System.out.println("exchange:" + exchange.getName());
        System.out.println("queue:" + queue.getName());
        this.rabbitTemplate.convertAndSend(exchange.getName(), queue.getName(), msgId);
    }
}
