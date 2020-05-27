package com.luffy.datastructure.commonlib.array;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0, 2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        System.out.println(list.isEmpty());
        System.out.println(list.toString());
        System.out.println(list.contains(10));
        list.remove(9);
        System.out.println(list.toString());
        list.clear();
        System.out.println(list.isEmpty());
        System.out.println(list.toString());
    }
}
