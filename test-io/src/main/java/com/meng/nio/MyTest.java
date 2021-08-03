package com.meng.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MyTest {
    public static void main(String[] args) throws Exception {
        File file  = new File("d:/1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("java nio".getBytes());
        buffer.flip();
        channel.write(buffer);
        channel.close();
        fileOutputStream.close();
    }

    @Test
    public void testWrite1()  throws Exception {
        File file  = new File("d:/1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write("hello".getBytes());

    }

    @Test
    public void testRead() throws Exception{
        File file  = new File("d:/1.txt");
        InputStream in = new FileInputStream(file);
        StringBuilder sb = new StringBuilder();
        int length = 0;
        while ((length = in.read()) != -1) {
            sb.append((char)length);
        }
        System.out.println(sb.toString());
    }

    @Test
    public void testReader() throws Exception{
        File file  = new File("d:/1.txt");
        Reader in = new FileReader(file);
        StringBuilder sb = new StringBuilder();
        int length = 0;
        char[] bytes = new char[1024];
        while ((length = in.read(bytes)) != -1) {
            sb.append(bytes,0,length);
        }
        System.out.println(sb.toString());
    }
}
