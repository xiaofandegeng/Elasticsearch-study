package com.itcast.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * <p>DESC: TODO</p>
 * <p>DATE: 2021/4/30</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: liaohongwei</p>
 */
public class WorkQueues {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2.设置参数
        factory.setHost("172.16.5.128");
        factory.setPort(5672);
        factory.setVirtualHost("/test");
        factory.setUsername("test");
        factory.setPassword("test");
        //3.创建连接connection
        Connection connection = factory.newConnection();
        //4.创建channel
        Channel channel = connection.createChannel();
        //5.创建队列
        //queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
        // 1.queue:队列名称
        // 2.durable:是否持久化
        // 3.是否独占
        channel.queueDeclare("work_queue",true,false,false,null);
        //6.发送消息

        for (int i = 0; i < 10; i++) {
            String body = "work queues";
            body = i + body;
            //String exchange, String routingKey, BasicProperties props, byte[] body
            channel.basicPublish("","work_queue",null, body.getBytes());
        }



        //7.释放资源
        channel.close();
        connection.close();
    }
}
