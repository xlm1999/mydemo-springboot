package com.meng;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

import java.util.List;

public class ZKClient {
    public static void main(String[] args) throws InterruptedException {
        String connStr = "localhost:2181";
        ZkClient zk = new ZkClient(connStr);

        // 注册【数据】事件
        zk.subscribeDataChanges("/top/zhuzhu", new IZkDataListener() {

            @Override
            public void handleDataDeleted(String arg0) throws Exception {
                System.err.println("数据删除:" + arg0);

            }

            @Override
            public void handleDataChange(String arg0, Object arg1) throws Exception {
                System.err.println("数据修改:" + arg0 + "------" + arg1);

            }
        });

        zk.subscribeChildChanges("/top", new IZkChildListener() {

            @Override
            public void handleChildChange(String arg0, List<String> arg1) throws Exception {
                System.err.println("子节点发生变化：" + arg0);
                arg1.forEach(f -> {
                    System.out.println("content：" + f);
                });
            }
        });

        List<String> list = zk.getChildren("/");
        list.forEach(e -> {
            System.out.println(e);
        });

        String res = zk.create("/top/zhuzhu", "I love you", CreateMode.PERSISTENT);
        System.out.println("创建节点/top/zhuzhu成功:" + res);

        zk.writeData("/top/zhuzhu", "forerver");
        System.out.println("修改节点/top/zhuzhu数据成功");

        res = zk.readData("/top/zhuzhu");
        System.out.println("节点数据:" + res);

        Thread.sleep(1000);

//        zk.delete("/top/zhuzhu");
//        System.out.println("删除节点/top/zhuzhu成功");

        Thread.sleep(1000);

        System.out.println("------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            zk.create("/top/zhuzhu", "I love you", CreateMode.PERSISTENT);
            Thread.sleep(1000);
            zk.delete("/top/zhuzhu");
            Thread.sleep(1000);
        }


    }
}
