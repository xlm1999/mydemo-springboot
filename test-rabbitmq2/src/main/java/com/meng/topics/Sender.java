package com.meng.topics;

import com.meng.utils.ConnectionUtils;
import com.rabbitmq.client.*;

public class Sender {
	private static final String EXCHANGE = "test_exchange_topic";
 
	public static void main(String[] args) {
		Connection con = null;
		Channel channel = null;
		try {
			// 获取连接
			con = ConnectionUtils.getConnection();
			// 从连接中创建通道
			channel = con.createChannel();
			// 声明交换机,采用topic类型
			channel.exchangeDeclare(EXCHANGE, BuiltinExchangeType.TOPIC, false, false, null);
			// 消息
			String msg = "你好 exchange topic!";
			// 发送消息
			channel.basicPublish(EXCHANGE, "quick.orange.rabbit", null, msg.getBytes());
			System.out.println("send success");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			ConnectionUtils.close(channel, con);
		}
	}
}