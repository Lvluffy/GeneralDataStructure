package com.luffy.datastructure.commonlib.linkedList;

import com.luffy.datastructure.commonlib.array.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.isEmpty());
        System.out.println(list.toString());
        System.out.println(list.toString());
        list.clear();
        System.out.println(list.isEmpty());
        System.out.println(list.toString());
    }
}
