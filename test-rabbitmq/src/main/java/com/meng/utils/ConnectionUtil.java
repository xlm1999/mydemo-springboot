package com.meng.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtil {
    public static Connection getConnection() {
        Connection connection = null;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("118.24.218.169");
        factory.setUsername("admin");
        factory.setPassword("123456");

        try {
            connection = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
