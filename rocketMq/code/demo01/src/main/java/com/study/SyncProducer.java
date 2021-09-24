package com.study;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * @Description rocketMq简单示例
 * @Author lhw
 * @Date 2021/9/23 14:44
 * @Version 1.0
 **/
public class SyncProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        // 创建生产者
        DefaultMQProducer producer = new DefaultMQProducer("test01");
        // 设置命名地址
        producer.setNamesrvAddr("localhost:9876");
        // 开启服务
        producer.start();

        for (int i = 0; i < 100; i++) {
            // 构造消息
            Message message = new Message("TopicTest01",
                    "TagTest01",
                    ("Hello,rocketMq " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));

            // 发送消息
            SendResult sendResult = producer.send(message);
            System.out.printf("%s%n",sendResult);
        }

        // 关闭服务
        producer.shutdown();
    }
}
