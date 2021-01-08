package com.luffy.datastructure.commonlib.queue;

/**
 * Created by lvlufei on 2021-01-08
 *
 * @name 数组实现队列
 */
public class ArrayQueue<T> {
    private Object[] data;
    private int size;
    private int front;  //前
    private int rear;   //后

    public ArrayQueue() {
        data = new Object[10];
        front = 0;
        rear = -1;
    }

    void enqueue(T t) {
        rear++;
        data[rear] = t;
        size++;
    }

    T dequeue() {
        T t = (T) data[front];
        front++;
        size--;
        return t;
    }

    int size() {
        return size;
    }

    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.enqueue("1");

        System.out.println(queue.size());
        System.out.println(queue.dequeue());

        queue.enqueue("2");

        System.out.println(queue.size());
        System.out.println(queue.dequeue());

        queue.enqueue("3");

        System.out.println(queue.size());
        System.out.println(queue.dequeue());
    }
}
