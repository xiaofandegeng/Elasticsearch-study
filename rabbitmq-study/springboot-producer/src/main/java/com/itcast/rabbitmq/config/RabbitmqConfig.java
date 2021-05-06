package com.itcast.rabbitmq.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>DESC: rabbitmq的配置类</p>
 * <p>DATE: 2021/5/6</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: liaohongwei</p>
 */
@Configuration
public class RabbitmqConfig {
    // 交换机名称
    public static final String EXCHANGE_TOPIC_NAME = "boot_topic_name";
//    public static final String EXCHANGE_TOPIC_NAME = "boot_topic_name";
//    public static final String EXCHANGE_TOPIC_NAME = "boot_topic_name";

    // 队列名称
    public static final String QUEUE_NAME = "boot_queue";

    // 1.交换机
    @Bean("bootExchange")
    public Exchange bootExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPIC_NAME).durable(true).build();
    }
    // 2.queue队列
    @Bean("bootQueue")
    public Queue bootQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }
    // 3.队列和交换机的绑定关系

    @Bean()
    public Binding bootBinding(@Qualifier("bootQueue") Queue queue,@Qualifier("bootExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs();
    }
}
