package com.meng.simulation_send_email;

import com.meng.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Producer {
    public static void main(String[] args) throws Exception{
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("queue_mail", false, false, false,null);

        for (int i = 0; i < 10; i++) {
            String email = "email_" + i + "@163.com";

            channel.basicPublish("", "queue_mail", null, email.getBytes());
            System.out.println("[producer]待发送的邮箱为" + email);
        }
    }
}
