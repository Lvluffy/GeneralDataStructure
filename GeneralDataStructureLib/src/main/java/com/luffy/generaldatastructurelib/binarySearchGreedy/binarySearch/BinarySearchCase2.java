package com.luffy.generaldatastructurelib.binarySearchGreedy.binarySearch;

/**
 * Created by lvlufei on 2019/11/12
 *
 * @name 二分搜索
 * @desc 案例分析二：找模糊的边界
 * <p>
 * 二分搜索可以用来查找一些模糊的边界。模糊的边界指：边界的值并不等于目标的值，而是大于或者小于目标的值。
 * <p>
 * 题目：从数组 {-2,0,1,4,7,9,10} 中找到第一个大于6的数。
 * <p>
 * 解题思路：
 * 在一个排好序的数组里，判断一个数是不是第一个大于 6 的数，只要它满足如下的条件：
 * 1，该数要大于6；
 * 2，该数有可能是数组里的第一个数，或者它之前的一个数比6小。
 * 只要满足了上面的条件就是第一个大于6的数。
 */
public class BinarySearchCase2 {

    /**
     * 二分搜索-递归解法
     *
     * @param nums   数组数据
     * @param target 目标值
     * @param left   左边索引（起点）
     * @param right  右边索引（终点）
     * @return 返回目标值所在数组索引
     */
    public static int binarySearchRecursion(int[] nums, int target, int left, int right) {
        //为了避免无限循环，先判断，如果起点位置大于终点位置，表明超出了搜索区间，无法找到目标数，返回-1。
        if (left > right) {
            return -1;
        }
        //取中位数。
        int middle = left + (right - left) / 2;
        //判断中位数是否为要找的数，如果是，就返回中位数下标。
        if (nums[middle] > target && (middle == 0 || nums[middle - 1] <= target)) {
            return middle;
        }
        //如果目标值在左边，就从左半边递归地进行二分搜索；否则从右半边递归地进行二分搜索。
        if (target < nums[middle]) {
            return binarySearchRecursion(nums, target, left, middle - 1);//在左半边继续进行二分搜索
        } else {
            return binarySearchRecursion(nums, target, middle + 1, right);//在右半边继续进行二分搜索
        }
    }


    /**
     * 二分搜索-非递归解法
     *
     * @param nums   数组数据
     * @param target 目标值
     * @param left   左边索引（起点）
     * @param right  右边索引（终点）
     * @return 返回目标值所在数组索引
     */
    public static int binarySearch(int[] nums, int target, int left, int right) {
        //在while循环里，判断搜索的区间范围是否有效
        while (left <= right) {
            //取中位数
            int middle = left + (right - left) / 2;
            //判断中位数是否为要找的数，如果是，就返回中位数下标。
            if (nums[middle] > target && (middle == 0 || nums[middle - 1] <= target)) {
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

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 4, 7, 9, 10};
        int target = 6;
        //递归解法
        int resultIndexRecursion = binarySearchRecursion(nums, target, 0, nums.length - 1);
        System.out.println("二分搜索-递归解法：" + resultIndexRecursion);
        //非递归解法
        int resultIndex = binarySearch(nums, target, 0, nums.length - 1);
        System.out.println("二分搜索-非递归解法：" + resultIndex);
    }

}
