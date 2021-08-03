package com.meng.work_queue;

import com.meng.utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer2 {

    private static final String QUEUE = "test_work_queue";

    public static void main(String[] args) throws Exception {
        // 获取连接
        Connection con = ConnectionUtils.getConnection();
        // 从连接中创建通道
        Channel channel = con.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE, false, false, false, null);
        // 创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            // 获取消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "utf-8");
                System.out.println("Recver2接收到消息——" + msg);
                // 模拟延迟,每1秒处理一个消息
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 手动确认消息，false：表示确认接收消息。true表示拒绝接收消息
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }

        };
        // 监听队列
        channel.basicConsume(QUEUE, false, consumer);
    }
}