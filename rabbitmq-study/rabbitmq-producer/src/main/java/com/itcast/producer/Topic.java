package com.itcast.producer;

import com.rabbitmq.client.BuiltinExchangeType;
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
public class Topic {
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
        //5.创建交换机
        /**
         * exchangeDeclare(
         *      String exchange, 交换机名称
         *      BuiltinExchangeType type, 交换机类型
         *      boolean durable, 持久化
         *      boolean autoDelete, 字段删除
         *      boolean internal, 内部使用一般 false
         *      Map<String, Object> arguments) 参数
         *
         */
        String exchange = "test_topic";
        channel.exchangeDeclare(exchange, BuiltinExchangeType.TOPIC, true, false, false, null);

        //6.创建队列
        //queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
        // 1.queue:队列名称
        // 2.durable:是否持久化
        // 3.是否独占
        String topic1 = "test_topic_queue1";
        String topic2 = "test_topic_queue2";
        channel.queueDeclare(topic1,true,false,false,null);
        channel.queueDeclare(topic2,true,false,false,null);
        //7.绑定队列和交换机
        /***
         * (String queue, String exchange, String routingKey, Map<String, Object> arguments)
         */
        //队列1绑定routingkey
        channel.queueBind(topic1,exchange,"error.*", null);
        //队列2绑定routingkey
        channel.queueBind(topic2,exchange,"#.info", null);
        channel.queueBind(topic2,exchange,"log.*", null);
        channel.queueBind(topic2,exchange,"error.*", null);

        String mes = "error.log123";
        //8.发送消息
        String body = "日志信息：这是一条测试信息，日志信息为：" + mes;
        //String exchange, String routingKey, BasicProperties props, byte[] body
        channel.basicPublish(exchange, mes,null, body.getBytes());

        //9.释放资源
        channel.close();
        connection.close();
    }
}
