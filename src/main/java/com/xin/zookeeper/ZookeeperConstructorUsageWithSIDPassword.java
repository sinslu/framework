package com.xin.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xsl on 2019/3/25.
 */
public class ZookeeperConstructorUsageWithSIDPassword implements Watcher {
    private static CountDownLatch countDownLatch=new CountDownLatch(1);
    public static void main(String[] args)throws  Exception {
        ZooKeeper zooKeeper=new ZooKeeper("127.0.30.185:2181",5000,new ZookeeperConstructorUsageWithSIDPassword());
        countDownLatch.await();
        long sessionId=zooKeeper.getSessionId();
        byte[] password=zooKeeper.getSessionPasswd();

        zooKeeper=new ZooKeeper("127.0.30.185:2181",5000,new ZookeeperConstructorUsageWithSIDPassword(),123,"234".getBytes());
        zooKeeper=new ZooKeeper("127.0.30.185:2181",5000,new ZookeeperConstructorUsageWithSIDPassword(),sessionId,password);

        Thread.sleep(Integer.MAX_VALUE);
    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("watch:"+watchedEvent);
        if(watchedEvent.getState()== Event.KeeperState.SyncConnected){
            countDownLatch.countDown();
        }
    }
}
