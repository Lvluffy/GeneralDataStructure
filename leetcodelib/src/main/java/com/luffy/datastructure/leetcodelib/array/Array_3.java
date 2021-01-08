package com.luffy.datastructure.leetcodelib.array;

/**
 * Created by lvlufei on 2021-01-08
 *
 * @name 给定有序数组，查找一个数字在数组中的位置。
 * <p>
 * 例如：输入：[1,2,3,4,5,6,7]，6 输出：5
 * 例如：输入：[1,2,3,4,5,6,7]，8 输出：-1
 */
public class Array_3 {

    public static int getIndex(int[] input, int target) {
        int start = 0;
        int mid;
        int end = input.length - 1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target > input[mid]) {
                start = mid + 1;
            } else if (target < input[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(getIndex(input1, 6));
        System.out.println(getIndex(input1, 8));
    }
}
