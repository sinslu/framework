package com.xin.zookeeper;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xsl on 2019/3/25.
 */
public class ZookeeperCreateAPIASyncUsage implements Watcher {
    private static CountDownLatch countDownLatch=new CountDownLatch(1);
    public static void main(String[] args)throws  Exception {
        ZooKeeper zooKeeper=new ZooKeeper("127.0.30.185:2181",5000,new ZookeeperCreateAPIASyncUsage());
        countDownLatch.await();
        zooKeeper.create("/zk-test-ephemeral","testdata".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,new IStringCallBack(),"I am context ...");
        zooKeeper.create("/zk-test-ephemeral","testdata".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,new IStringCallBack(),"I am context ...");
        zooKeeper.create("/zk-test-ephemeral","testdata".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL,new IStringCallBack(),"I am context ...");
        Thread.sleep(50000);
    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("watch:"+watchedEvent);
        if(watchedEvent.getState()== Event.KeeperState.SyncConnected){
            countDownLatch.countDown();
        }
    }


   static class IStringCallBack implements AsyncCallback.StringCallback{
        @Override
        public void processResult(int i, String s, Object o, String s1) {
            System.out.println("result code:"+i+",path name:"+s+",context:"+o+"real path name:"+s1);
        }
    }
}
