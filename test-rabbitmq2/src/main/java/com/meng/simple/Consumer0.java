package com.meng.simple;

import com.meng.utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer0 {
    private static final String QUEUE_NAME = "test_simple_queue";

    public static void main(String[] args) {
        Connection connection = null;
        Channel channel = null;
        try {
            // 获取连接
            connection = ConnectionUtils.getConnection();
            // 创建通道
            channel = connection.createChannel();

            // 声明一个队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            // 创建消费者
            com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
                // 获取消息
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "utf-8");
                    System.out.println("[消费者]接收到的消息为：" + message);
                }
            };

            // 监听队列
            channel.basicConsume(QUEUE_NAME, true, consumer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            ConnectionUtils.close(channel, connection);
        }


    }
}
