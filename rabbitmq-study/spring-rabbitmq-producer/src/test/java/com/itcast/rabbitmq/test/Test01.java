package com.itcast.rabbitmq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
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

    // 测试确认消息
    @Test
    public void testConfirm() {
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                System.out.println("confirm方法被执行了......");
                if (b) {
                    System.out.println("消息接收成功：" + s);
                }else {
                    System.out.println("消息接收失败：" + s);
                }
            }
        });

        // 发送消息
        rabbitTemplate.convertAndSend("test_exchange_confirm", "confirm","confirm message....");
    }
    // 测试回退消息
    @Test
    public void testReturn() {
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("return方法被执行了......");
                System.out.println(message);
                System.out.println(replyCode);
                System.out.println(replyText);
                System.out.println(exchange);
                System.out.println(routingKey);
            }
        });

        rabbitTemplate.convertAndSend("test_exchange_confirm", "return2132", "return message......");
    }

    // 测试消费端限流
    @Test
    public void testQos() {
        for (int i = 0; i < 20; i++) {
            Object mes = "confirm message...." + i;
            rabbitTemplate.convertAndSend("test_exchange_confirm", "confirm", mes);
        }
    }

    // 测试消费端限流
    @Test
    public void testTtl() {
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration("5000");
                return message;
            }
        };
        for (int i = 0; i < 20; i++) {
            Object mes = "test ttl message...." + i;
            if(i ==0 || i ==5 || i== 10){
                rabbitTemplate.convertAndSend("test_exchange_ttl", "ttl.haha", mes, messagePostProcessor);
            } else {
                rabbitTemplate.convertAndSend("test_exchange_ttl", "ttl.haha", mes);
            }
        }
    }

    /**
     *  测试死信消息
     *  1.消息过期进入死信队列
     *  2.消息队列过长进入死信队列
     *  3.消费者拒收进入死信队列
     */
    @Test
    public void testDlx() {
        //1.消息过期进入死信队列
        //rabbitTemplate.convertAndSend("test_exchange_dlx", "test.dlx.haha","我是一条消息，我会死吗？");

//        //2.消息队列过长进入死信队列
//        for (int i = 0; i < 20; i++) {
//            rabbitTemplate.convertAndSend("test_exchange_dlx", "test.dlx.haha","我是一条消息，我会死吗？");
//        }

        //3.消费者拒绝接收进入死信队列
        rabbitTemplate.convertAndSend("test_exchange_dlx", "test.dlx.haha","我是一条消息，我会死吗？");
    }
}
