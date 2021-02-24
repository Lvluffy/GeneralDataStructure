package com.luffy.datastructure.leetcodelib.array;

import java.util.Arrays;

/**
 * Created by lvlufei on 2021-01-21
 *
 * @name 合并两个有序数组
 * <p>
 * 示例1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * <p>
 * 示例2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 */
public class LeetCode_88 {

    public static void main(String[] args) {
        int[] nums1_1 = {1, 2, 3, 0, 0, 0};
        int[] nums2_1 = {2, 5, 6};
        System.out.println("合并后排序：" + Arrays.toString(merge_1(nums1_1, 3, nums2_1, 3)));

        int[] nums1_2 = {1, 2, 3, 0, 0, 0};
        int[] nums2_3 = {2, 5, 6};
        System.out.println("双指针：" + Arrays.toString(merge_2(nums1_2, 3, nums2_3, 3)));
    }

    /**
     * 合并后排序
     * <p>
     * 时间复杂度 : O((n+m)log(n+m))
     * 空间复杂度 : O(1)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static int[] merge_1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        return nums1;
    }

    /**
     * 双指针/从后往前
     * <p>
     * 时间复杂度 : O(n+m)
     * 空间复杂度 : O(1)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static int[] merge_2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        return nums1;
    }
}
