package com.meng.test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket ss = null;
        PrintWriter pw = null;
        BufferedReader br = null;

        try
        {
            // 实例化监听端口
            ss = new ServerSocket(1111);
        }
        catch (IOException e)
        {
            System.err.println("Could not listen on port:1111");
            System.exit(1);
        }
        Socket incoming = null;
        while (true)
        {
            incoming = ss.accept();
            pw = new PrintWriter(incoming.getOutputStream(), true);
            // 先将字节流通过InputStreamReader转换为字符流，之后将字符流放入缓冲之中
            br = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
            // 提示信息
            pw.println("Hello!...");
            pw.println("Enter BYE to exit");
            pw.flush();
            // 没有异常则不断循环
            while (true)
            {
                // 只有当用户输入时才返回数据
                String str = br.readLine();
                // 当用户连接断掉时会返回空值null
                if (str == null)
                {
                    // 退出循环
                    break;
                }
                else
                {
                    // 对用户输入字符串加前缀Echo并将此信息打印到客户端
                    pw.println("Echo：" + str);
                    pw.flush();
                    // 退出命令，equalsIgnoreCase()是不区分大小写的
                    if ("BYE".equalsIgnoreCase(str.trim()))
                    {
                        break;
                    }
                }
            }
            // 该close的资源都close掉
            pw.close();
            br.close();
            incoming.close();
            ss.close();
        }
    }
}