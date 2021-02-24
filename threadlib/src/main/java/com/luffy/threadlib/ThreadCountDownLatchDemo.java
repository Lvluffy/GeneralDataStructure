package com.luffy.threadlib;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lvlufei on 2021-02-22
 *
 * @name 让线程按顺序执行之CountDownLatch
 * <p>
 * CountDownLatch:位于java.util.concurrent包下，利用它可以实现类似计数器的功能。
 */
public class ThreadCountDownLatchDemo {

    /**
     * 用于判断线程一是否执行，倒计时设置为1，执行后减1
     */
    private static CountDownLatch countDownLatch1 = new CountDownLatch(1);

    /**
     * 用于判断线程二是否执行，倒计时设置为1，执行后减1
     */
    private static CountDownLatch countDownLatch2 = new CountDownLatch(1);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("第一步");
                Thread.sleep(1000);
                // countDownLatch1 倒计时-1
                countDownLatch1.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                //等待countDownLatch1倒计时，计时为0则往下运行
                countDownLatch1.await();
                System.out.println("第二步");
                Thread.sleep(1000);
                //对countDownLatch2倒计时-1
                countDownLatch2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                //等待countDownLatch2倒计时，计时为0则往下运行
                countDownLatch2.await();
                System.out.println("第三步");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
