package com.xin.zookeeper;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xsl on 2019/3/25.
 */
public class ZookeeperCreateAPISyncUsage implements Watcher {
    private static CountDownLatch countDownLatch=new CountDownLatch(1);
    public static void main(String[] args)throws  Exception {
        ZooKeeper zooKeeper=new ZooKeeper("127.0.30.185:2181",5000,new ZookeeperCreateAPISyncUsage());
        countDownLatch.await();
        String path1=zooKeeper.create("/zk-test-ephemeral","testdata".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("create success ,path:"+path1);
        String path2=zooKeeper.create("/zk-test-ephemeral222","testdata".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("create success ,path:"+path2);
    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("watch:"+watchedEvent);
        if(watchedEvent.getState()== Event.KeeperState.SyncConnected){
            countDownLatch.countDown();
        }
    }
}
