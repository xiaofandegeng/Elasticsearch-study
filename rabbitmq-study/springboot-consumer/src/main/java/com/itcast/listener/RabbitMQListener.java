package com.itcast.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>DESC: TODO</p>
 * <p>DATE: 2021/5/6</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: liaohongwei</p>
 */
@Component
public class RabbitMQListener {

    @RabbitListener(queues = {"boot_queue"})
    public void getMes(Message message) {
        System.out.println(new String(message.getBody()));
    }
}
