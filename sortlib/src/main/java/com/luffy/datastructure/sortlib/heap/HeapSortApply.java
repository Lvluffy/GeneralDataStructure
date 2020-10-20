package com.luffy.datastructure.sortlib.heap;

import com.luffy.datastructure.SwapUtils;

/**
 * Created by lvlufei on 2019/11/11
 *
 * @name 堆排序
 * @desc --
 * <p>
 * 堆排序是基于堆这种数据结构的一种排序算法。
 * <p>
 * 堆是一颗完全二叉树，堆有最大堆和最小堆。最大堆中每个父节点都比它的子结点大，最小堆中每个父节点都比它的子结点小。
 * <p>
 * 特点：
 * 1，堆中根结点是最大值或者最小值。
 * 2，将堆层序遍历的结果放入数组中（数组index从0开始），index=a的两个子结点是2a+1和2a+2。
 * <p>
 * 过程：堆排序从小到大排序，首先将数组元素建成大小为n的大顶堆，堆顶（数组第一个元素）是所有元素中的最大值，将堆顶元素和数组最后一个元素进行交换，
 * 再将除了最后一个数的n-1个元素建立成大顶堆，再将最大元素和数组倒数第二个元素进行交换，重复直至堆大小减为1。
 * <p>
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * <p>
 * 题目：给定一个数组[2,1,7,9,5,8]，要求按照从左到右、从小到大的顺序进行排序。
 */
public class HeapSortApply {
    /**
     * 堆排序
     *
     * @param nums 数组数据
     * @return
     * @throws Exception
     */
    public static int[] headSort(int[] nums) throws Exception {
        if (nums == null || nums.length == 0) {
            throw new Exception("参数错误");
        }
        for (int i = (nums.length - 2) / 2; i >= 0; i--) {
            heapAdjust(nums, i, nums.length - 1);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            SwapUtils.getInstance().swapDifficult(nums, 0, i);
            heapAdjust(nums, 0, i - 1);
        }
        return nums;
    }

    /**
     * 堆整理
     *
     * @param nums  数组数据
     * @param start 开始位置
     * @param end   结束位置
     */
    private static void heapAdjust(int[] nums, int start, int end) {
        int temp = nums[start];
        int j;
        for (j = start * 2 + 1; j <= end; j = j * 2 + 1) {
            if (j < end && nums[j] < nums[j + 1]) {
                j++;
            }
            if (temp >= nums[j]) {
                break;
            }
            nums[start] = nums[j];
            start = j;
        }
        nums[start] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 7, 9, 5, 8};
        try {
            headSort(nums);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i : nums) {
            System.out.print(i + "    ");
        }
    }
}
