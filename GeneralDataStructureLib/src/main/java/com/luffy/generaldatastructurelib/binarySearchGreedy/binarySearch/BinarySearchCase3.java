package com.luffy.generaldatastructurelib.binarySearchGreedy.binarySearch;

/**
 * Created by lvlufei on 2019/11/12
 *
 * @name 二分搜索
 * @desc 案例分析三：旋转过的排序数组
 * <p>
 * 二分搜索也能在经过旋转了的排序数组中进行。
 * <p>
 * 题目：给定一个经过旋转了的排序数组，判断一下某个数是否在里面。
 * <p>
 * 示例：
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 */
public class BinarySearchCase3 {

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
        if (nums[middle] == target) {
            return middle;
        }
        //如果目标值在左边，就从左半边递归地进行二分搜索；否则从右半边递归地进行二分搜索。
        if (nums[left] <= nums[middle]) {
            //如果排好序的在左边，就在左半边继续进行二分搜索，否则在右半边进行二分搜索。
            if (nums[left] <= target && target < nums[middle]) {
                return binarySearchRecursion(nums, target, left, middle - 1);
            }
            return binarySearchRecursion(nums, target, middle + 1, right);
        } else {
            //如果排好序的在右边，就在右半边继续进行二分搜索，否则在左半边进行二分搜索。
            if (nums[middle] < target && target <= nums[right]) {
                return binarySearchRecursion(nums, target, middle + 1, right);
            }
            return binarySearchRecursion(nums, target, left, middle - 1);
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
            if (nums[middle] == target) {
                return middle;
            }
            //如果目标值在左边，调整搜索区间的终点为"middle - 1"；否则，调整搜索区间的起点为"middle + 1"。
            if (nums[left] <= nums[middle]) {
                //如果目标值在左边，调整搜索区间的终点为"middle - 1"；否则，调整搜索区间的起点为"middle + 1"。
                if (nums[left] <= target && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                //如果目标值在右边，调整搜索区间的起点为"middle + 1"；否则，调整搜索区间的终点为"middle - 1"。
                if (nums[middle] < target && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }

            }
        }
        //如果超出了搜索区间，表明无法找到目标数，返回-1。
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        //递归解法
        int resultIndexRecursion = binarySearchRecursion(nums, target, 0, nums.length - 1);
        System.out.println("二分搜索-递归解法：" + resultIndexRecursion);
        //非递归解法
        int resultIndex = binarySearch(nums, target, 0, nums.length - 1);
        System.out.println("二分搜索-非递归解法：" + resultIndex);
    }

}
