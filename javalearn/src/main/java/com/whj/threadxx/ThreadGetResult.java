package com.whj.threadxx;

import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * @description: 获取线程调用结果的3中方式
 * @author: whj
 * @createTime: 2022-01-09 15:21
 * @version: 1.0
 */
public class ThreadGetResult {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test01();
//        test02();
        test03();
    }

    private static void test03() throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {
                return 10;
            }
        });
        final Object o = completableFuture.get();
        System.out.println("输出结果"+o);
    }

    private static void test02() throws ExecutionException, InterruptedException {
        final FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return 10;
            }
        });
        new Thread(futureTask).start();
        final Object x = futureTask.get();
        System.out.println("输出结果"+x);


    }


    private static void test01() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Future<Integer> future = executorService.submit(() -> {
            return 10;
        });
        executorService.shutdown(); //一定要关闭
        final Integer integer = future.get();
        System.out.println("输出结果"+integer);
    }


}

