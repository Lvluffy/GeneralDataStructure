package com.luffy.threadlib;

import java.util.concurrent.Semaphore;

/**
 * Created by lvlufei on 2021-02-22
 *
 * @name 让线程按顺序执行之信号量（Semaphore）
 * <p>
 * Sephmore(信号量):Semaphore是一个计数信号量,从概念上将，Semaphore包含一组许可证,如果有需要的话，每个acquire()方法都会阻塞，直到获取一个可用的许可证,每个release()
 * 方法都会释放持有许可证的线程，并且归还Semaphore一个可用的许可证。然而，实际上并没有真实的许可证对象供线程使用，Semaphore只是对可用的数量进行管理维护。
 * <p>
 * acquire():当前线程尝试去阻塞的获取1个许可证,此过程是阻塞的,当前线程获取了1个可用的许可证，则会停止等待，继续执行。
 * <p>
 * release():当前线程释放1个可用的许可证。
 */
public class ThreadSemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);

        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("第一步");
                Thread.sleep(1000);
                //释放许可证
                semaphore1.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                //获取许可证
                semaphore1.acquire();
                System.out.println("第二步");
                Thread.sleep(1000);
                //释放许可证
                semaphore2.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                //获取许可证
                semaphore2.acquire();
                thread2.join();
                //释放许可证
                semaphore2.release();
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
