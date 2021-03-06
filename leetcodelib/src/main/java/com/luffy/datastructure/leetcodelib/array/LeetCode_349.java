package com.luffy.datastructure.leetcodelib.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lvlufei on 2021-01-14
 *
 * @name 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2] 输出：[2]
 * <p>
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出：[9,4]
 */
public class LeetCode_349 {

    public static void main(String[] args) {
        int[] num1_1 = {1, 2, 2, 1};
        int[] num2_1 = {2, 2};
        System.out.println("循环遍历：" + Arrays.toString(intersection_1(num1_1, num2_1)));
        System.out.println("双集合：" + Arrays.toString(intersection_2(num1_1, num2_1)));
        System.out.println("排序 + 双指针：" + Arrays.toString(intersection_3(num1_1, num2_1)));

        int[] num1_2 = {4, 9, 5};
        int[] num2_2 = {9, 4, 9, 8, 4};
        System.out.println("循环遍历：" + Arrays.toString(intersection_1(num1_2, num2_2)));
        System.out.println("双集合：" + Arrays.toString(intersection_2(num1_2, num2_2)));
        System.out.println("排序 + 双指针：" + Arrays.toString(intersection_3(num1_2, num2_2)));
    }

    /**
     * 循环遍历
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection_1(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (list.contains(nums1[i])) {
                break;
            }
            list.add(nums1[i]);
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    resultList.add(nums1[i]);
                    break;
                }
            }
        }
        int[] result = new int[resultList.size()];
        int index = 0;
        for (int i : resultList) {
            result[index] = i;
            index++;
        }
        return result;
    }

    /**
     * 双集合
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection_2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int item : nums1) {
            set1.add(item);
        }
        for (int item : nums2) {
            if (set1.contains(item)) {
                set2.add(item);
            }
        }
        int[] result = new int[set2.size()];
        int index = 0;
        for (int item : set2) {
            result[index] = item;
            index++;
        }
        return result;
    }

    /**
     * 排序 + 双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection_3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length1 = nums1.length;
        int length2 = nums2.length;

        int[] intersection = new int[length1 + length2];

        int index = 0;
        int index1 = 0;
        int index2 = 0;

        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];

            if (num1 == num2) {
                // 保证加入元素的唯一性
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
