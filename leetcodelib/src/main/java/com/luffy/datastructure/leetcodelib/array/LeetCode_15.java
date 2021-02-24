package com.luffy.datastructure.leetcodelib.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lvlufei on 2020-12-07
 *
 * @name 三数之和
 * <p>
 * 题目：给定一个集合S，试找出3个数a, b, c，使得a+b+c=0。也即从集合中找出所有的和为0的3个数。
 * <p>
 * 例如：集合S={-1，0， 1， 2， -1， 4}，则满足条件的3个数有2对：(-1, 0, 1)和(-1, 2, -1)。
 * 注意（-1，1，0）与（-1，0，1）算同一个解，所以不用重复考虑。
 */
public class LeetCode_15 {

    public static void main(String[] args) {
        int[] data = {-1, 0, 1, 2, -1, 4};
        System.out.println("暴力法：" + threeSum_1(data));
        System.out.println("双指针法" + threeSum_2(data));
    }

    /**
     * 暴力法
     * <p>
     * 时间复杂度：o(n^3)
     * 空间复杂度：o(1)
     *
     * @param data
     * @return
     */
    public static List<List<Integer>> threeSum_1(int[] data) {
        // 进行排序去重
        Arrays.sort(data);
        // 寻找
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < data.length; first++) {
            if (first > 0 && data[first] == data[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < data.length; second++) {
                if (second > first + 1 && data[second] == data[second - 1]) {
                    continue;
                }
                for (int third = second + 1; third < data.length; third++) {
                    if (third > second + 1 && data[third] == data[third - 1]) {
                        continue;
                    }
                    boolean b = data[first] + data[second] + data[third] == 0;
                    if (b) {
                        List<Integer> list = new ArrayList<>();
                        list.add(data[first]);
                        list.add(data[second]);
                        list.add(data[third]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 双指针法
     * <p>
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(logN)
     *
     * @param data
     * @return
     */
    public static List<List<Integer>> threeSum_2(int[] data) {
        int length = data.length;
        // 进行排序去重
        Arrays.sort(data);
        // 寻找
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < length; ++first) {
            if (first > 0 && data[first] == data[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < length; ++second) {
                if (second > first + 1 && data[second] == data[second - 1]) {
                    continue;
                }

                // 对应的指针初始指向数组的最右端
                int third = length - 1;
                int target = -data[first];

                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && data[second] + data[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (data[second] + data[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(data[first]);
                    list.add(data[second]);
                    list.add(data[third]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
