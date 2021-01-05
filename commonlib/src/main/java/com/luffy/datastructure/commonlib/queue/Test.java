package com.luffy.datastructure.commonlib.queue;

public class Test {

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
