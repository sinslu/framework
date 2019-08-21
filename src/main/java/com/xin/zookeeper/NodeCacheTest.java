package com.xin.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * Created by xsl on 2019/8/20.
 * 节点监听，可以多次监听而不用反复注册
 */
public class NodeCacheTest {
    private static String path="/zk-book/nodecache";
    private static CuratorFramework curatorFramework= CuratorFrameworkFactory.builder()
            .connectString("127.0.30.185:2181")
            .sessionTimeoutMs(5000).retryPolicy(new ExponentialBackoffRetry(1000,3)).build();

    public static void main(String[] args) throws Exception{
        curatorFramework.start();
        //创建节点、此方法提供了一次创建多个(原生API不支持递归创建节点)
        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path,"init".getBytes());
        NodeCache nodeCache=new NodeCache(curatorFramework,path);
        nodeCache.start(true);
        nodeCache.getListenable().addListener(()->{
            System.out.println("node data update");
            System.out.println("new data:"+new String(nodeCache.getCurrentData().getData()));
        });

        Thread.sleep(Integer.MAX_VALUE);
    }
}
