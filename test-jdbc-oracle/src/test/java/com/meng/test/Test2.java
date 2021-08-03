package com.meng.test;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
    @Test
    public void test1() throws Exception {
        //连接对象
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//10.110.75.105:1521/RDMTDB", "admin", "RDM123test");
        //创建调用存储过程的对象CallableStatement
        CallableStatement call=null;
        ResultSet resultSet=null;   //存放结果集
        //调用存储过程的sql语句
        String sql="{call pro_findAllDept(?)}";
        List<?> deptList=new ArrayList<>();  //存放所有部门
        try {
            call=conn.prepareCall(sql);
            //申明输出参数类型：下标从1开始
            call.registerOutParameter(1, OracleTypes.CURSOR);   //返回多行：游标类型
            //执行调用
            call.execute();

            //接收返回的结果
            resultSet=((OracleCallableStatement)call).getCursor(1);
            while (resultSet.next()){

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            conn.close();

        }
    }
}
