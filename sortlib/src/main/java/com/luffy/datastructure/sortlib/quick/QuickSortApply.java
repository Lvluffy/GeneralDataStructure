package com.luffy.datastructure.sortlib.quick;

/**
 * Created by lvlufei on 2019/11/8
 *
 * @name 快速排序
 * @desc --
 * <p>
 * 基本原理：快速排序也采用了分治的思想。
 * <p>
 * 实现：把原始的数组筛选成较小和较大的两个子数组，然后递归地排序两个子数组。
 * <p>
 * 过程：快速排序从小到大排序：在数组中随机选一个数（默认数组首个元素），数组中小于等于此数的放在左边，大于此数的放在右边，再对数组两边递归调用快速排序，重复这个过程。
 * <p>
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(logn)
 * <p>
 * 题目：给定一个数组[2,1,7,9,5,8]，要求按照从左到右、从小到大的顺序进行排序。
 */
public class QuickSortApply {

    /**
     * 获取基准值索引
     */
    private static int getIndex(int[] data, int start, int end) {
        int tmp = data[start];
        while (start < end) {
            while (start < end && data[end] >= tmp) {
                end--;
            }
            data[start] = data[end];
            while (start < end && data[start] <= tmp) {
                start++;
            }
            data[end] = data[start];

        }
        data[start] = tmp;
        return start;
    }

    /**
     * 快速排序
     */
    public static int[] quickSort(int[] data, int start, int end) {
        if (data == null || data.length == 0) {
            return data;
        }
        if (start < end) {
            // 获取基准值索引
            int index = getIndex(data, start, end);
            // 左边排序
            quickSort(data, 0, index);
            // 右边排序
            quickSort(data, index + 1, end);
        }
        return data;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 7, 9, 5, 8};
        quickSort(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.print(i + "    ");
        }
    }
}
