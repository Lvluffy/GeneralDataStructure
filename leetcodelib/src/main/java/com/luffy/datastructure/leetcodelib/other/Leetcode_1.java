package com.luffy.datastructure.leetcodelib.other;

/**
 * Created by lvlufei on 2020-12-16
 *
 * @name 计算斐波那契数列的第n项的值
 */
public class Leetcode_1 {
    public static int calNumberByRecursion(Integer n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return calNumberByRecursion(n - 1) + calNumberByRecursion(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(calNumberByRecursion(3));
        System.out.println(calNumberByRecursion(4));
        System.out.println(calNumberByRecursion(5));
        System.out.println(calNumberByRecursion(6));
        System.out.println(calNumberByRecursion(7));
        System.out.println(calNumberByRecursion(8));
    }
}
