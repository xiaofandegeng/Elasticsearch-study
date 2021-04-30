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
public class Routing {
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
        String exchange = "test_direct";
        channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT, true, false, false, null);

        //6.创建队列
        //queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
        // 1.queue:队列名称
        // 2.durable:是否持久化
        // 3.是否独占
        String direct1 = "test_direct1";
        String direct2 = "test_direct2";
        channel.queueDeclare(direct1,true,false,false,null);
        channel.queueDeclare(direct2,true,false,false,null);
        //7.绑定队列和交换机
        /***
         * (String queue, String exchange, String routingKey, Map<String, Object> arguments)
         */
        //队列1绑定routingkey
        channel.queueBind(direct1,exchange,"error", null);
        //队列2绑定routingkey
        channel.queueBind(direct2,exchange,"error", null);
        channel.queueBind(direct2,exchange,"info", null);
        channel.queueBind(direct2,exchange,"waring", null);

        //8.发送消息
        String body = "日志信息：这是一条测试信息，日志级别为：error";
        //String exchange, String routingKey, BasicProperties props, byte[] body
        channel.basicPublish(exchange,"error",null, body.getBytes());

        //9.释放资源
        channel.close();
        connection.close();
    }
}
