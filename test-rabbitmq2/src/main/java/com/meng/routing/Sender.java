package com.meng.routing;

import com.meng.utils.ConnectionUtils;
import com.rabbitmq.client.*;

public class Sender {
 
	private static final String EXCHANGE = "test_exchange_direct";
	
	public static void main(String[] args) {
		Connection con = null;
		Channel channel = null;
		try {
			// 获取连接
			con = ConnectionUtils.getConnection();
			// 从连接中创建通道
			channel = con.createChannel();
			// 声明交换机,采用direct类型
			channel.exchangeDeclare(EXCHANGE, BuiltinExchangeType.DIRECT,false,false,null);
			// 消息
			String msg = "你好 exchange direct!";
			// 发送消息,指定路由键
			channel.basicPublish(EXCHANGE, "info", null, msg.getBytes());
			System.out.println("send success");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			ConnectionUtils.close(channel, con);
		}
	}
}