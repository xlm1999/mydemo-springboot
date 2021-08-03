package com.meng.work_queue;

import com.meng.utils.ConnectionUtils;
import com.rabbitmq.client.*;

public class Producer {

    private static final String QUEUE = "test_work_queue";

    public static void main(String[] args) {
        Connection con = null;
        Channel channel = null;
        try {
            // 获取连接
            con = ConnectionUtils.getConnection();
            // 从连接中创建通道
            channel = con.createChannel();
            // 声明一个队列
            channel.queueDeclare(QUEUE, true, false, false, null);
            // 限制发送给同一个消费者不超过1条消息
            channel.basicQos(1);
            // 发送50条消息
            for (int i = 0; i < 50; i++) {
                // 消息内容
                String msg = "work queue " + i;
                // 发送消息
                channel.basicPublish("", QUEUE, null, msg.getBytes());
                try {
                    Thread.sleep(i * 20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("send success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            ConnectionUtils.close(channel, con);
        }
    }
}
