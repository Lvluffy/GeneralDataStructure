package com.luffy.generaldatastructurelib.binarySearchGreedy.binarySearch;

/**
 * Created by lvlufei on 2019/11/12
 *
 * @name 二分搜索
 * @desc 案例：搜索旋转排序数组
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * (例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2])。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 1，你可以假设数组中不存在重复的元素。
 * 2，你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例：
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 */
public class BinarySearchCase1 {
    /**
     * @param nums   数组数据
     * @param target 目标值
     * @return
     */
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0)
            return -1;
        if (n == 1)
            return nums[0] == target ? 0 : -1;
        int rotate_index = find_rotate_index(nums, 0, n - 1);
        if (nums[rotate_index] == target)
            return rotate_index;
        if (rotate_index == 0)
            return search(nums, target, 0, n - 1);
        if (target < nums[0])
            return search(nums, target, rotate_index, n - 1);
        return search(nums, target, 0, rotate_index);
    }

    /**
     * @param nums  数组数据
     * @param left  左边索引
     * @param right 右边索引
     * @return
     */
    private static int find_rotate_index(int[] nums, int left, int right) {
        if (nums[left] < nums[right])
            return 0;
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }

    /**
     * @param nums   数组数据
     * @param target 目标值
     * @param left   左边索引
     * @param right  右边索引
     * @return
     */
    private static int search(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = search(nums, target);
        System.out.print(result);
    }

}
