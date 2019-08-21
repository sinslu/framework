package com.xin.zookeeper;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xsl on 2019/8/20.
 * CyclicBarrier 控制让所有线程在同一时刻开始
 *
 */
public class CyclicBarrierTest {
    public static CyclicBarrier barrier=new CyclicBarrier(3);

    static class Runner implements Runnable{
        private String name;
        public Runner(String name){
            this.name=name;
        }
        @Override
        public void run() {
            System.out.println(name+" 选手准备好了！");
            try {
                barrier.wait();
            }catch (Exception e){}
            System.out.println(name+" 起跑！");
        }
    }


    public static void main(String[] args) throws Exception{
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        executorService.submit(new Thread(new Runner("1号选手")));
        executorService.submit(new Thread(new Runner("2号选手")));
        executorService.submit(new Thread(new Runner("3号选手")));
        executorService.shutdown();
    }
}
