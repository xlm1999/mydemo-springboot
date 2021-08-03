package com.meng;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class Zk {
    public static void main(String[] args) throws Exception {
        //计数器对象
        final CountDownLatch latch = new CountDownLatch(1);

        ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 500, new Watcher() {
            public void process(WatchedEvent event) {
                if(event.getState() ==Watcher.Event.KeeperState.SyncConnected){
                    System.out.println("连接创建成功");
                    latch.countDown();
                }
            }
        });

        //主线程阻塞等待连接对象的创建成功
        latch.await();
        zooKeeper.create("/create","create".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("----"+zooKeeper.getSessionId()+"----");
        zooKeeper.close();

    }
}
