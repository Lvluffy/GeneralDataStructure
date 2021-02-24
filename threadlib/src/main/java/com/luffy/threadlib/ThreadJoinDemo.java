package com.luffy.threadlib;

/**
 * Created by lvlufei on 2021-02-22
 *
 * @name 让线程按顺序执行之Join
 * <p>
 * join():是Theard的方法，作用是调用线程需等待该join()线程执行完成后，才能继续用下运行。
 */
public class ThreadJoinDemo {
    public static void main(String[] args) {
        childThreadUseJoin();
        try {
            mainThreadUseJoin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 子线程中使用Join
     */
    public static void childThreadUseJoin() {
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("子线程中使用Join：第一步");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
                System.out.println("子线程中使用Join：第二步");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
                System.out.println("子线程中使用Join：第三步");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 主线程中使用Join
     */
    public static void mainThreadUseJoin() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("主线程中使用Join：第一步");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("主线程中使用Join：第二步");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                System.out.println("主线程中使用Join：第三步");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
    }
}
