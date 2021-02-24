package com.luffy.datastructure.leetcodelib.array;

/**
 * Created by lvlufei on 2021-01-08
 *
 * @name 返回数组中连续出现指定元素的最大次数。要求：时间复杂度o(n)，空间复杂度：o(1)
 * <p>
 * 例如：
 * 输入：[1,1,1,0,0,1,1,0,1]   连续出现1的最多次数：3
 * 输入：[0]                   连续出现1的最多次数：0
 * 输入：[0,0,1,0,1,0,1]       连续出现1的最多次数：1
 */
public class Array_1 {

    public static void main(String[] args) {
        int[] input1 = {1, 1, 1, 0, 0, 1, 1, 0, 1};
        System.out.println(getMaxNum(input1, 1));

        int[] input2 = {0};
        System.out.println(getMaxNum(input2, 1));

        int[] input3 = {0, 0, 1, 0, 1, 0, 1};
        System.out.println(getMaxNum(input3, 1));
    }

    public static int getMaxNum(int[] input, int find) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int maxNum = 0;
        int cont = 0;
        for (int i : input) {
            if (i == find) {
                cont++;
                if (cont > maxNum) {
                    maxNum = cont;
                }
            } else {
                cont = 0;
            }
        }
        return maxNum;
    }
}
