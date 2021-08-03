package com.meng.test;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test1 {
    @Test
    public void test1() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //获取连接
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//10.110.75.105:1521/RDMTDB", "admin", "RDM123test");
        conn.setAutoCommit(false);     //因为在默认状态下，执行成功的语句会默认的提交，所以事先设置为不自动提交。
        PreparedStatement ps = null;
        try {
            String sql1 = "select * from t_sys_emp where email=?";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, "mengxianlei@inspur.com");
            ResultSet resultSet = ps.executeQuery();


            conn.commit();         // 如果两个语句都执行成功，就让语句提交，
            System.out.println("chenggong");
            System.out.println(resultSet);
        } catch (Exception e) {
            conn.rollback();       //否则就让他回滚到执行2条语条前的状态
            System.out.println("shibai" + e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
    }
}
