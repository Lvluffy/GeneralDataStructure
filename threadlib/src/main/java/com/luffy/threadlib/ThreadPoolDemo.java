package com.luffy.threadlib;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lvlufei on 2021-02-22
 *
 * @name 让线程按顺序执行之线程池（Executors）
 * <p>
 * JAVA通过Executors提供了四种线程池
 * 1，单线程化线程池(newSingleThreadExecutor);
 * 2，可控最大并发数线程池(newFixedThreadPool);
 * 3，可回收缓存线程池(newCachedThreadPool);
 * 4，支持定时与周期性任务的线程池(newScheduledThreadPool)。
 * <p>
 * 线程池的参数
 * 1，corePoolSize（核心线程数）
 * 2，maximumPoolSize（最大线程数）
 * 3，keepAliveTime（线程保活时间）
 * 4，workQueue（任务队列）
 * 5，threadFactory（线程工厂)
 * 6，handler（线程饱和策略）
 * <p>
 * 单线程化线程池(newSingleThreadExecutor):优点，串行执行所有任务。
 * <p>
 * submit()：提交任务。
 * shutdown()：方法用来关闭线程池，拒绝新任务。
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("第一步");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("第二步");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                System.out.println("第三步");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);
        executorService.shutdown();
    }
}
