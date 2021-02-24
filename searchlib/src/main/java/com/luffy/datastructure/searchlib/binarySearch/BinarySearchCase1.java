package com.luffy.datastructure.searchlib.binarySearch;

import java.util.Arrays;

/**
 * Created by lvlufei on 2019/11/12
 *
 * @name 二分搜索
 * @desc 案例分析一：找确定的边界
 * <p>
 * 边界分上边界和下边界，有时候也被成为右边界和左边界。确定的边界指：边界的数值等于要找的目标数。
 * <p>
 * 题目：在一个排好序的数组中找出某个数第一次出现和最后一次出现的下标位置。
 * <p>
 * 示例：
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 */
public class BinarySearchCase1 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        BinarySearchCase1 binarySearchCase1 = new BinarySearchCase1();
        //递归解法
        int[] resultIndexRecursion = binarySearchCase1.binarySearchRecursion(nums, target, 0, nums.length - 1);
        System.out.println("二分搜索-递归解法:" + Arrays.toString(resultIndexRecursion));

        //非递归解法
        int[] resultIndex = binarySearchCase1.binarySearch(nums, target, 0, nums.length - 1);
        System.out.println("二分搜索-非递归解法:"+Arrays.toString(resultIndex));
    }

    /**
     * 二分搜索-递归解法
     *
     * @param nums   数据数组
     * @param target 目标值
     * @param left   左边索引（起点）
     * @param right  右边索引（终点）
     * @return
     */
    public int[] binarySearchRecursion(int[] nums, int target, int left, int right) {
        int[] bounds = new int[2];
        bounds[0] = searchLeftBoundRecursion(nums, target, left, right);
        bounds[1] = searchRightBoundRecursion(nums, target, left, right);
        return bounds;
    }

    /**
     * 搜索左边界-递归解法
     *
     * @param nums   数组数据
     * @param target 目标值
     * @param left   左边索引（起点）
     * @param right  右边索引（终点）
     * @return 返回目标值所在数组索引
     */
    private int searchLeftBoundRecursion(int[] nums, int target, int left, int right) {
        //为了避免无限循环，先判断，如果起点位置大于终点位置，表明超出了搜索区间，无法找到目标数，返回-1。
        if (left > right) {
            return -1;
        }
        //取中位数。
        int middle = left + (right - left) / 2;
        //判断中位数是否为要找的数，如果是，就返回中位数下标。
        if (nums[middle] == target && (middle == 0 || nums[middle - 1] < target)) {
            return middle;
        }
        //如果目标值在左边，就从左半边递归地进行二分搜索；否则从右半边递归地进行二分搜索。
        if (target <= nums[middle]) {
            return searchLeftBoundRecursion(nums, target, left, middle - 1);
        } else {
            return searchLeftBoundRecursion(nums, target, middle + 1, right);
        }
    }

    /**
     * 搜索右边界-递归解法
     *
     * @param nums   数组数据
     * @param target 目标值
     * @param left   左边索引（起点）
     * @param right  右边索引（终点）
     * @return 返回目标值所在数组索引
     */
    private int searchRightBoundRecursion(int[] nums, int target, int left, int right) {
        //为了避免无限循环，先判断，如果起点位置大于终点位置，表明超出了搜索区间，无法找到目标数，返回-1。
        if (left > right) {
            return -1;
        }
        //取中位数。
        int middle = left + (right - left) / 2;
        //判断中位数是否为要找的数，如果是，就返回中位数下标。
        if (nums[middle] == target && (middle == nums.length - 1 || nums[middle + 1] > target)) {
            return middle;
        }
        //如果目标值在左边，就从左半边递归地进行二分搜索；否则从右半边递归地进行二分搜索。
        if (target < nums[middle]) {
            return searchRightBoundRecursion(nums, target, left, middle - 1);
        } else {
            return searchRightBoundRecursion(nums, target, middle + 1, right);
        }
    }

    /**
     * 二分搜索-非递归解法
     *
     * @param nums   数据数组
     * @param target 目标值
     * @param left   左边索引（起点）
     * @param right  右边索引（终点）
     * @return
     */
    public int[] binarySearch(int[] nums, int target, int left, int right) {
        int[] bounds = new int[2];
        bounds[0] = searchLeftBound(nums, target, left, right);
        bounds[1] = searchRightBound(nums, target, left, right);
        return bounds;
    }

    /**
     * 搜索左边界-非递归解法
     *
     * @param nums   数组数据
     * @param target 目标值
     * @param left   左边索引（起点）
     * @param right  右边索引（终点）
     * @return 返回目标值所在数组索引
     */
    private int searchLeftBound(int[] nums, int target, int left, int right) {
        //在while循环里，判断搜索的区间范围是否有效
        while (left <= right) {
            //取中位数
            int middle = left + (right - left) / 2;
            //判断中位数是否为要找的数，如果是，就返回中位数下标。
            if (nums[middle] == target && (middle == 0 || nums[middle - 1] < target)) {
                return middle;
            }
            //如果目标值在左边，调整搜索区间的终点为"middle - 1"；否则，调整搜索区间的起点为"middle + 1"。
            if (target <= nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        //如果超出了搜索区间，表明无法找到目标数，返回-1。
        return -1;
    }

    /**
     * 搜索右边界-非递归解法
     *
     * @param nums   数组数据
     * @param target 目标值
     * @param left   左边索引（起点）
     * @param right  右边索引（终点）
     * @return 返回目标值所在数组索引
     */
    private int searchRightBound(int[] nums, int target, int left, int right) {
        //在while循环里，判断搜索的区间范围是否有效
        while (left <= right) {
            //取中位数
            int middle = left + (right - left) / 2;
            //判断中位数是否为要找的数，如果是，就返回中位数下标。
            if (nums[middle] == target && (middle == nums.length - 1 || nums[middle + 1] > target)) {
                return middle;
            }
            //如果目标值在左边，调整搜索区间的终点为"middle - 1"；否则，调整搜索区间的起点为"middle + 1"。
            if (target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        //如果超出了搜索区间，表明无法找到目标数，返回-1。
        return -1;
    }
}
