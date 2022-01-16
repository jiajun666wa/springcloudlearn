package com.whj.juc;


import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;


/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2022-01-05 14:28
 * @version: 1.0
 */
public class AAA {
    public static void main(String[] args) {
        BlockingQueue q = new SynchronousQueue();
        Producer p = new Producer(q);
        Consumer c1 = new Consumer(q);
        Consumer c2 = new Consumer(q);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }


}

class Producer implements Runnable {
    private final BlockingQueue queue;
    Producer(BlockingQueue q) {
        queue = q;
    }
    public void run() {
        try {
            while (true) {

                queue.put(produce());
            }
        } catch (InterruptedException ex) { }
    }
    Object produce() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("生产者准备生产产品！！！");
        return new Random().nextInt();
    }
}

class Consumer implements Runnable {
    private final BlockingQueue queue;
    Consumer(BlockingQueue q) {
        queue = q;
    }
    public void run() {
        try {
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                consume();
            }
        } catch (InterruptedException ex) {

        }
    }

    private Object consume() throws InterruptedException {
        System.out.println("消费者等待消费产品......");
        System.out.println(queue.take());
        return null;

    }

}

