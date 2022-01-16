package com.whj.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2022-01-05 12:17
 * @version: 1.0
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
//        一个阻塞队列，其中每个插入操作都必须等待另一个线程执行相应的移除操作，反之亦然。
        BlockingQueue blockingQueue = new SynchronousQueue();
         Lock lock = new ReentrantLock();


        for (int i = 1; i <=10; i++) {
            final int threadNum =i;
            new Thread(()->{
                try {
                    blockingQueue.put(threadNum);
                    System.out.println("线程"+Thread.currentThread().getName()+"生产了一个产品。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },threadNum+"").start();//生产者
        }
        for (int j = 21; j <=30; j++) {
            final int threadNum =j;
            new Thread(()->{
                try {
                    blockingQueue.take();
                    System.out.println("线程"+Thread.currentThread().getName()+"消费了一个产品。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },threadNum+"").start();//生产者
        }




    }
}
