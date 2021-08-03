package com.meng.simulation_send_email;

import com.meng.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

public class Consumer {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("queue_mail", false, false, false,null);
        QueueingConsumer consumer = new QueueingConsumer(channel);

        channel.basicConsume("queue_mail", true, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String email = new String(delivery.getBody());
            System.out.println("[consumer]待发送的邮箱为" + email);
        }


    }
}
