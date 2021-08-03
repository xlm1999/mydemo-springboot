package com.meng.utils;
 
import java.io.IOException;
import java.util.concurrent.TimeoutException;
 
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
 
/**
 * rabbitmq连接工具类
 * @author Administrator
 *
 */
public class ConnectionUtils {
	/**
	 * 获取连接
	 * @return
	 * @throws IOException
	 * @throws TimeoutException
	 */
	public static Connection getConnection() throws IOException, TimeoutException{
		ConnectionFactory factory = new ConnectionFactory();
		// 设置服务地址
		factory.setHost("118.24.218.169");
		// 端口
		factory.setPort(5672);
		// vhost
		factory.setVirtualHost("/");
		// 用户名
		factory.setUsername("admin");
		// 密码
		factory.setPassword("123456");
		return factory.newConnection();
	}
	/**
	 * 关闭连接
	 * @param channel
	 * @param con
	 */
	public static void close(Channel channel,Connection con){
		if(channel != null){
			try {
				channel.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
 
}