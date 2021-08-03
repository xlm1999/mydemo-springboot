package com.meng.topic;
 
import com.meng.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 通配模式
 * @author lenovo
 *
 */
public class Producer {
 
	private final static String EXCHANGE_NAME = "test_exchange_topic";
 
    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
 
        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
 
        // 消息内容  模拟 有人购物下订单
        String message = "新增订单:id=101";
        channel.basicPublish(EXCHANGE_NAME, "order.insert.aaa", null, message.getBytes());
        System.out.println(" [生产者] Sent '" + message + "'");
 
        channel.close();
        connection.close();
    }
	
}