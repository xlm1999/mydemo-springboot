package com.meng.publish_subscribe;

import com.meng.utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Recver1 {
	/**
	 * 交换机名称
	 */
	private static final String EXCHANGE = "test_exchange_fanout";
	private static final String QUEUE = "test_queue_email";
 
	public static void main(String[] args) throws Exception {
		// 获取连接
		Connection con = ConnectionUtils.getConnection();
		// 从连接中创建通道
		final Channel channel = con.createChannel();
		// 声明队列
		channel.queueDeclare(QUEUE, true, false, false, null);
		// 绑定交换机
		channel.queueBind(QUEUE, EXCHANGE, "");
		// 保证一次只分发一条消息
		channel.basicQos(1);
		// 创建消费者
		Consumer consumer = new DefaultConsumer(channel) {
			// 获取消息
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
					throws IOException {
				String msg = new String(body, "utf-8");
				System.out.println("Recver1接收到消息——" + msg);
				// 手动确认消息
				channel.basicAck(envelope.getDeliveryTag(), false);
			}
 
		};
		// 监听队列
		channel.basicConsume(QUEUE, false, consumer);
	}
}