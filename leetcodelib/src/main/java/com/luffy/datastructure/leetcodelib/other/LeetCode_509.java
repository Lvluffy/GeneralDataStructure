package com.luffy.datastructure.leetcodelib.other;

/**
 * Created by lvlufei on 2020-12-16
 *
 * @name 计算斐波那契数列的第n项的值
 */
public class LeetCode_509 {

    public static void main(String[] args) {
        System.out.println("递归法：" + calNumberByRecursion_1(0));
        System.out.println("动态规划：" + calNumberByRecursion_2(0));
        System.out.println("递归法：" + calNumberByRecursion_1(1));
        System.out.println("动态规划：" + calNumberByRecursion_2(1));
        System.out.println("递归法：" + calNumberByRecursion_1(2));
        System.out.println("动态规划：" + calNumberByRecursion_2(2));
        System.out.println("递归法：" + calNumberByRecursion_1(3));
        System.out.println("动态规划：" + calNumberByRecursion_2(3));
        System.out.println("递归法：" + calNumberByRecursion_1(4));
        System.out.println("动态规划：" + calNumberByRecursion_2(4));
        System.out.println("递归法：" + calNumberByRecursion_1(5));
        System.out.println("动态规划：" + calNumberByRecursion_2(5));
        System.out.println("递归法：" + calNumberByRecursion_1(6));
        System.out.println("动态规划：" + calNumberByRecursion_2(6));
        System.out.println("递归法：" + calNumberByRecursion_1(7));
        System.out.println("动态规划：" + calNumberByRecursion_2(7));
        System.out.println("递归法：" + calNumberByRecursion_1(8));
        System.out.println("动态规划：" + calNumberByRecursion_2(8));
    }

    /**
     * 递归法
     *
     * @param n
     * @return
     */
    public static int calNumberByRecursion_1(int n) {
        if (n < 2) {
            return n;
        }
        return calNumberByRecursion_1(n - 1) + calNumberByRecursion_1(n - 2);
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int calNumberByRecursion_2(int n) {
        if (n < 2) {
            return n;
        }
        int pre = 0;
        int cur = 0;
        int result = 1;
        for (int i = 2; i <= n; ++i) {
            pre = cur;
            cur = result;
            result = pre + cur;
        }
        return result;
    }
}
