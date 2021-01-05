package com.luffy.datastructure.commonlib.queue;

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
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue("1");

        System.out.println(arrayQueue.size());
        System.out.println(arrayQueue.dequeue());

        arrayQueue.enqueue("2");

        System.out.println(arrayQueue.size());
        System.out.println(arrayQueue.dequeue());

        arrayQueue.enqueue("3");

        System.out.println(arrayQueue.size());
        System.out.println(arrayQueue.dequeue());
    }
}
