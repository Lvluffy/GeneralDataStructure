package com.luffy.generaldatastructurelib.binarySearchGreedy.binarySearch;

/**
 * Created by lvlufei on 2019/11/12
 *
 * @name 二分搜索
 * @desc --
 * <p>
 * 定义：
 * 二分搜索是一种在有序数组中查找某一特定元素的搜索算法。
 * 从定义可知，运用二分搜索的前提是数组必须是排好序的。另外，输入并不一定数组，也可能是给定一个区间的起始点和终止点的位置。
 * <p>
 * 优缺点：
 * 优点：时间复杂度是O(lgn)，非常高效。因此也成为对数搜索。
 * 缺点：要求待查找的数组或者区间是排好序的。
 * <p>
 * 核心步骤：
 * 1，确定搜索的范围和区域
 * 2，取中间的数判断是否满足条件
 * 3，如果不满足条件，判定应该往哪个半边继续进行搜索。
 * <p>
 * 题目：在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例：
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 */
public class BinarySearchApply {

    /**
     * @param nums   数据数组
     * @param target 目标值
     * @return
     */
    public static int[] binarySearch(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        // 左边索引
        int leftIndex = extremeInsertionIndex(nums, target, true);
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return targetRange;
        }
        targetRange[0] = leftIndex;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
        return targetRange;
    }

    /**
     * 极端插入索引
     *
     * @param nums   数据数组
     * @param target 目标值
     * @param left   是否是左边
     * @return
     */
    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = binarySearch(nums, target);
        for (int i : result) {
            System.out.print(i + "    ");
        }
    }

}
