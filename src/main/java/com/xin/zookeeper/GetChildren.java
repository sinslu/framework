package com.xin.zookeeper;

import org.apache.zookeeper.*;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by xsl on 2019/8/20.
 */
public class GetChildren {
    private static CountDownLatch countDownLatch=new CountDownLatch(1);
    public static ZooKeeper zk=null;

    public static void main(String[] args)throws  Exception {
        zk=new ZooKeeper("127.0.30.185:2181",5000,new ChildrenWatch());
        countDownLatch.await();
        String path="/zk-book";
        //创建父节点
        //zk.create(path,"".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        //创建子节点
        zk.create(path+"/c1","".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);

        //获取子节点
        List<String> childrens=zk.getChildren(path,true);
        System.out.println("子节点："+childrens);
        Thread.sleep(Integer.MAX_VALUE);
    }

    static class ChildrenWatch implements Watcher{
        @Override
        public void process(WatchedEvent watchedEvent) {
            if(watchedEvent.getState()== Event.KeeperState.SyncConnected){
                //初始连接成功通知
                if(watchedEvent.getType()== Event.EventType.None &&watchedEvent.getPath()==null){
                    countDownLatch.countDown();
                //当子节点发生变化时会接到通知，但是只会通知一次
                }else if(watchedEvent.getType()== Event.EventType.NodeChildrenChanged){
                    System.out.println("getChildren:"+zk);
                }
            }
        }
    }
}

