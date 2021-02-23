package com.luffy.threadlib;

/**
 * Created by lvlufei on 2021-02-22
 *
 * @name 让线程按顺序执行之wait/notify
 * <p>
 * wait():是Object的方法，作用是让当前线程进入等待状态，同时，wait()也会让当前线程释放它所持有的锁。“直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法”，当前线程被唤醒(进入“就绪状态”)
 * <p>
 * notify()和notifyAll():是Object的方法，作用则是唤醒当前对象上的等待线程；notify()是唤醒单个线程，而notifyAll()是唤醒所有的线程。
 */
public class ThreadWaitDemo {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    private static Boolean t1Run = false;
    private static Boolean t2Run = false;

    public static void main(String[] args) {

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    try {
                        System.out.println("第一步");
                        Thread.sleep(1000);
                        t1Run = true;
                        lock1.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    try {
                        if (!t1Run) {
                            lock1.wait();
                        }
                        synchronized (lock2) {
                            System.out.println("第二步");
                            Thread.sleep(1000);
                            t2Run = true;
                            lock2.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    try {
                        if (!t2Run) {
                            lock2.wait();
                        }
                        System.out.println("第三步");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread3.start();
        thread1.start();
        thread2.start();
    }
}
