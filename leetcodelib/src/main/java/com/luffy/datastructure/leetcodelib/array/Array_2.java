package com.luffy.datastructure.leetcodelib.array;

import java.util.Arrays;

/**
 * Created by lvlufei on 2021-01-08
 *
 * @name 返回数组中当前索引后面的最大值，最后一个元素为-1。要求：时间复杂度o(n)，空间复杂度：o(1)
 * <p>
 * 例如：输入：[3,8,1,10,6,8,1]   返回：[10,10,10,8,8,1,-1]
 * 例如：输入：[1,5]              返回：[5,-1]
 * 例如：输入：[5,1]              返回：[1,-1]
 * 例如：输入：[1]                返回：[-1]
 * 例如：输入：[]                `返回：[]
 */
public class Array_2 {

    public static int[] getData(int[] input) {
        int max = -1;
        int temp;
        for (int i = input.length - 1; i >= 0; i--) {
            temp = input[i];
            input[i] = max;
            if (temp > max) {
                max = temp;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input1 = {3, 8, 1, 10, 6, 8, 1};
        System.out.println(Arrays.toString(getData(input1)));

        int[] input2 = {1, 5};
        System.out.println(Arrays.toString(getData(input2)));

        int[] input3 = {5, 1};
        System.out.println(Arrays.toString(getData(input3)));

        int[] input4 = {1};
        System.out.println(Arrays.toString(getData(input4)));

        int[] input5 = {};
        System.out.println(Arrays.toString(getData(input5)));
    }
}
