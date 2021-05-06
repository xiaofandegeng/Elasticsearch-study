package com.itcast.rabbitmq.test;

import com.itcast.rabbitmq.config.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * <p>DESC: 测试生产者是否配置正确</p>
 * <p>DATE: 2021/5/6</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: liaohongwei</p>
 */

@SuppressWarnings("ALL")
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerTest {

    // 注入rabbitmqTemplate模板
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void SendMes() {
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_TOPIC_NAME, "boot.haha", "boot hello mq");
    }
}
