package com.luffy.generaldatastructurelib.binarySearchGreedy.binarySearch;

/**
 * Created by lvlufei on 2019/11/12
 *
 * @name 二分搜索（折半搜索）
 * @desc --
 * <p>
 * 定义：
 * 是一种在有序数组中查找某一特定元素的搜索算法。从定义可知，运用二分搜索的前提是数组必须是排好序的。另外，输入并不一定是数组，也有可能是给定一个区间的起始和终止的位置。
 * <p>
 * 优点：时间复杂度是O(lgn)，非常高效。因此也成为对数搜索。
 * 缺点：要求待查找的数组或者区间是排好序的。
 * <p>
 * 解题思路：
 * <p>
 * 1，从已经排好序的数组或区间中取出中间位置的元素，判断该元素是否满足要搜索的条件，如果满足，停止搜索，程序结束。
 * 2，如果正中间的元素不满足条件，则从它两边的区域进行搜索。由于数组是排好序的，可以利用排除法，确定接下来应该从这两个区间中的哪一个去搜索。
 * 3，通过判断，如果发现真正要找的元素在左半区间的话，就继续在左半区间里进行二分搜索。反之，就在右半区间里进行二分搜索。
 * <p>
 * 核心步骤:
 * 1，确定搜索的范围和区间
 * 2，取中间的数判断是否满足条件
 * 3，如果不满足条件，判定应该往哪个半边继续进行搜索
 * <p>
 * 题目：假设我们要从一个排好序的数组里 {1, 3, 4, 6, 7, 8, 10, 13, 14} 查看一下数字 7 是否在里面，如果在，返回它的下标，否则返回 -1。
 * <p>
 * 解题方法：递归解法、非递归解法
 * <p>
 * 递归解法：
 * 优点：简洁；缺点：执行消耗大
 * <p>
 * 注意：
 * 1，在计算 middle 下标的时候，不能简单地用 (left + right) / 2，可能会导致溢出。
 * 2，在取左半边以及右半边的区间时，左半边是 [left, middle - 1]，右半边是 [middle + 1, right]，这是两个闭区间。因为已经确定了 middle 那个点不是我们要找的，就没有必要再把它加入到左、右半边了。
 * 3，对于一个长度为奇数的数组，例如：{1, 2, 3, 4, 5}，按照 left + (right - left) / 2 来计算，middle 就是正中间的那个位置，对于一个长度为偶数的数组，例如 {1, 2, 3, 4}，middle 就是正中间靠左边的一个位置。
 */
public class BinarySearchApply {

    /**
     * 二分搜索-递归解法
     *
     * @param nums   数组数据
     * @param target 目标值
     * @param left   左边索引（起点）
     * @param right  右边索引（终点）
     * @return 返回目标值所在数组索引
     */
    public int binarySearchRecursion(int[] nums, int target, int left, int right) {
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
        if (target < nums[middle]) {
            return binarySearch(nums, target, left, middle - 1);
        } else {
            return binarySearch(nums, target, middle + 1, right);
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
    public int binarySearch(int[] nums, int target, int left, int right) {
        //在while循环里，判断搜索的区间范围是否有效
        while (left <= right) {
            //取中位数
            int middle = left + (right - left) / 2;
            //判断中位数是否为要找的数，如果是，就返回中位数下标。
            if (nums[middle] == target) {
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
        int[] nums = {1, 3, 4, 6, 7, 8, 10, 13, 14};
        int target = 7;
        BinarySearchApply binarySearchApply = new BinarySearchApply();
        //递归解法
        int resultIndexRecursion = binarySearchApply.binarySearchRecursion(nums, target, 0, nums.length - 1);
        System.out.println("二分搜索-递归解法：" + resultIndexRecursion);
        //非递归解法
        int resultIndex = binarySearchApply.binarySearch(nums, target, 0, nums.length - 1);
        System.out.println("二分搜索-非递归解法：" + resultIndex);
    }
}
