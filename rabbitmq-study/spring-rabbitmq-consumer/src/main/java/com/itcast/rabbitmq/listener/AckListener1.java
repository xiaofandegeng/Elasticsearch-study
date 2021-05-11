package com.itcast.rabbitmq.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.ChannelListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <p>DESC: Consumer ACK机制
 *      1.设置手动签收，acknowledge="manual"
 *      2.让监听器实现ChannelAwareMessageListener接口
 *      3.如果消息成功处理，则调用channel的basicAck()签收
 *      4.如果消息失败处理，则调用channel的basicNack()拒收，broker重新发送给consumer
 * </p>
 * <p>DATE: 2021/5/11</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: liaohongwei</p>
 */
@Component
public class AckListener1 implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            TimeUnit.SECONDS.sleep(3);
            // 1.打印消息
            System.out.println(new String(message.getBody()));
            // 2.业务逻辑 long deliveryTag, boolean multiple
            System.out.println("处理业务逻辑");
            //出现错误
            //int i = 10 / 0;
            // 消息成功处理，签收消息
            channel.basicAck(deliveryTag, true);
        } catch (Exception e){
            // 消息失败处理，返回给broker
            channel.basicNack(deliveryTag, true, true);
        }
    }
}
