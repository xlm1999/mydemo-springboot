package com.meng;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyTest {
    MySql mysql = new MySql();

    //Redis redis = new Redis();
    Jedis redis = new Jedis("118.24.218.169", 6379);

    {
        redis.auth("111111");
    }

    ResultSet rs = null;

    @Test

    public void redisLogin() throws SQLException {

        //正常业务的ID是通过UI的request.getParamenter()获取
        String id = "12";
        String sql = "select * from user where id='" + id + "'";
        String username;

        if (redis.hexists("user_" + id, "username_")) {
            username = redis.hget("user_" + id, "username_");
            System.out.println("Welcome Redis! User " + username + " login success");

        } else {
            rs = mysql.conn.createStatement().executeQuery(sql);
            if (rs.next() == false) {
                System.out.println("Mysql no register, Please register first");
            } else {
                username = rs.getString("username");
                System.out.println("Welcome Mysql ! User " + username + " login success");
                redis.hset("user_" + id, "username_", username);

                //30分钟未操作就过期
                redis.expire("user_" + id, 60);
            }
        }
    }

    @Test
    public void test1() {

    }

}
