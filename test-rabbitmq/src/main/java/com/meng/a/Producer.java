package com.meng.a;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    private static  final  String  QUEUE_NAME = "myQueue";
    public static void main(String[] args) throws IOException, TimeoutException {
        String message = "hello world";
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("118.24.218.169");
        factory.setUsername("admin");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,true,false,null);
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());

        System.out.println(" [x] Sent '" + message + "'");

    }
}
