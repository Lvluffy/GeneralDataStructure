package com.luffy.datastructure.leetcodelib.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by lvlufei on 2021-01-08
 *
 * @name 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 例如：输入：nums = [2,7,11,15], target = 9 输出：[0,1]
 * 例如：输入：nums = [3,2,4], target = 6     输出：[1,2]
 */
public class LeetCode_1 {

    /**
     * 时间复杂度：o(n^2) 空间复杂度：o(1)
     *
     * @param input
     * @param target
     * @return
     */
    public static int[] getResult_1(int[] input, int target) {
        if (input == null || input.length < 2) {
            return null;
        }
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] + input[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    /**
     * 时间换空间 时间复杂度：o(n) 空间复杂度：o(n)
     *
     * @param input
     * @param target
     * @return
     */
    public static int[] getResult_2(int[] input, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(input.length);
        map.put(input[0], 0);
        for (int i = 1; i < input.length; i++) {
            if (map.containsKey(target - input[i])) {
                return new int[]{map.get(target - input[i]), i};
            } else {
                map.put(input[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] input1 = {2, 7, 11, 15};
        System.out.println(Arrays.toString(getResult_1(input1, 9)));

        int[] input2 = {3, 2, 4};
        System.out.println(Arrays.toString(getResult_1(input2, 6)));
    }
}
