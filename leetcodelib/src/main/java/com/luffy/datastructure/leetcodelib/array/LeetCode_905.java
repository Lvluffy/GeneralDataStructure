package com.luffy.datastructure.leetcodelib.array;

import java.util.Arrays;

/**
 * Created by lvlufei on 2021-02-23
 *
 * @name 按奇偶排序数组
 * <p>
 * 题目：给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 */
public class LeetCode_905 {

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(sort_1(data)));
        System.out.println(Arrays.toString(sort_2(data)));
    }

    /**
     * 两边扫描
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param data
     * @return
     */
    public static int[] sort_1(int[] data) {
        int[] ans = new int[data.length];
        int index = 0;
        //奇数
        for (int i = 0; i < data.length; i++) {
            if (data[i] % 2 != 0) {
                ans[index++] = data[i];
            }
        }
        //偶数
        for (int i = 0; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                ans[index++] = data[i];
            }
        }
        return ans;
    }

    /**
     * 快慢指针
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param data
     * @return
     */
    public static int[] sort_2(int[] data) {
        int start = 0;
        int end = data.length - 1;
        int temp;
        while (start < end) {
            if (data[start] % 2 != 0) {
                start++;
            } else if (data[end] % 2 == 0) {
                end--;
            } else {
                temp = data[start];
                data[start] = data[end];
                data[end] = temp;
            }
        }
        return data;
    }
}
