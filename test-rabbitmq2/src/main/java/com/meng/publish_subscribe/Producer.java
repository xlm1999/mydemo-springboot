package com.meng.publish_subscribe;

import com.meng.utils.ConnectionUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Producer {
    private static final String EXCHANGE = "test_exchange_fanout";
    private static final String QUEUE = "test_queue_fanout";
    private static final String MESSAGE = "test_message_fanout";

    public static void main(String[] args){
        Connection connection = null;
        Channel channel = null;

        try {
            // 得到连接
            connection = ConnectionUtils.getConnection();
            // 创建通道
            channel = connection.createChannel();
            // 声明交换机
            channel.exchangeDeclare(EXCHANGE, BuiltinExchangeType.FANOUT, false, false,null);

            channel.basicPublish(EXCHANGE, "", null, MESSAGE.getBytes());
            System.out.println("send success");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
