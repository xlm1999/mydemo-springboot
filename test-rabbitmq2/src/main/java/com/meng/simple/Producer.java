package com.meng.simple;

import com.meng.utils.ConnectionUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Producer {
    private static final String QUEUE_NAME = "test_simple_queue";
    private static final String MESSAGE = "test_simple_message";

    public static void main(String[] args){
        Connection connection = null;
        Channel channel = null;
        try {
            // 获取连接
            connection = ConnectionUtils.getConnection();
            // 创建通道
            channel = connection.createChannel();
            // 声明一个队列
            AMQP.Queue.DeclareOk declareOk = channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            // 发送消息
            channel.basicPublish("", QUEUE_NAME, null, MESSAGE.getBytes());

            System.out.println("[生产者]发送消息成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtils.close(channel, connection);
        }

    }
}
