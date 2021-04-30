package com.itcast.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>DESC: TODO</p>
 * <p>DATE: 2021/4/30</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: liaohongwei</p>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-rabbitmq-producer.xml"})
public class Test01 {
    //自动导入rabbit模板
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testHelloworld() {
        rabbitTemplate.convertAndSend("spring_queue","Hello,spring......");
    }

    //发送fanout消息
    @Test
    public void testFanout() {
        //发送消息
        for (int i = 0; i < 10; i++) {
            String mes = "hello,spring fanout......" + i;
            rabbitTemplate.convertAndSend("spring_fanout_exchange", null, mes);
        }

    }

    //发送topic消息
    @Test
    public void testTopic() {
        //发送消息
        rabbitTemplate.convertAndSend("spring_topic_exchange", "heima.log.hah", "hello,spring topic......");
    }
}
