package com.itcast.rabbitmq.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 *
 * <p>DATE: 2021/5/11</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: liaohongwei</p>
 */
@Component
public class DlxListener implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            // 1.打印消息
            System.out.println(new String(message.getBody()));
            // 2.业务逻辑 long deliveryTag, boolean multiple
            System.out.println("处理业务逻辑");
            //出现错误
            int i = 10 / 0;
            // 消息成功处理，签收消息
            channel.basicAck(deliveryTag, true);
        } catch (Exception e){
            // 消息失败处理，返回给broker
            System.out.println("消息出错了，消费者拒绝接收，进入死信队列。");
            channel.basicNack(deliveryTag, true, false);
        }
    }
}
