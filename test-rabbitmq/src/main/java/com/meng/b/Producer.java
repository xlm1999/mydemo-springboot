package com.meng.b;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    private static  final  String  QUEUE_NAME = "myQueue_exchange";
    private static  String exchangeName = "amq.fanout";
    private static String routingKey = "test1";


    public static void main(String[] args) throws IOException, TimeoutException {
        String message = "hello world";
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("118.24.218.169");
        factory.setUsername("admin");
        factory.setPassword("123456");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(exchangeName,"fanout", true);
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.queueBind(QUEUE_NAME,exchangeName,routingKey);

        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

    }
}
