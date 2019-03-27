package com.xin.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;


/**
 * Created by xsl on 2019/3/25.
 */
public class ConfigTest {
    public static void main(String[] args) throws Exception{
        //ZooKeeper zooKeeper=new ZooKeeper("127.0.30.185:2181",5000,null);
        //byte[] data=zooKeeper.getData("/test1",false,null);
        //System.out.println(new String(data));

        CuratorFramework curatorFramework=CuratorFrameworkFactory.newClient("127.0.30.185:2181",5000,10000, new ExponentialBackoffRetry(1000,3));
        curatorFramework.start();
        byte[] data=curatorFramework.getData().forPath("/test1");
        System.out.println(new String(data));
        Stat stat=curatorFramework.setData().forPath("/test1","test".getBytes());
        System.out.println(stat);
        System.out.println("test");
    }
}
