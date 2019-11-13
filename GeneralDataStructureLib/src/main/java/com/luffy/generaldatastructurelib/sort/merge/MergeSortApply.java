package com.luffy.generaldatastructurelib.sort.merge;

/**
 * Created by lvlufei on 2019/11/7
 *
 * @name 归并排序
 * @desc --
 * <p>
 * 基本思想：核心是分治，就是把一个复杂的问题扽成两个或多个相同或相似的子问题，直到子问题可以简单的直接求解，最原问题的解就是子问题解的合并。归并排序将分治的思想体现的淋漓尽致。
 * <p>
 * 实现：一开始线把数组从中间划分成两个子数组，一直递归的把子数组划分成更小的子数组，直到子数组里面只有一个元素，才开始排序。
 * 排序的方法就是按照大小顺序合并两个元素，接着一次按照递归的返回顺序，不断地合并排好序的子数组，直到最后把整个数组的吮吸排好。
 * <p>
 * 过程：归并排序从小到大排序：首先让数组中的每一个数单独成为长度为1的区间，然后两两一组有序合并，得到长度为2的有序区间，依次进行，直到合成整个区间。
 * <p>
 * 空间复杂度：O(n)
 * 由于合并n个元素需要分配一个大小为n的额外数组，合并完成之后，这个数组的空间就会被释放，所以算法的空间复杂度就是O(n)。
 * 时间复杂度：O(nlogn)
 * <p>
 * 题目：给定一个数组[2,1,7,9,5,8]，要求按照从左到右、从小到大的顺序进行排序。
 */
public class MergeSortApply {
    /**
     * 归并排序
     *
     * @param nums 数组数据
     * @return
     */
    public static int[] mergeSort(int[] nums) throws Exception {
        if (nums == null || nums.length == 0)
            throw new Exception("参数错误");
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 排序
     *
     * @param nums  数组数据
     * @param start 开始位置
     * @param end   结束位置
     */
    private static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    /**
     * 合并
     *
     * @param nums  数组数据
     * @param start 开始位置
     * @param mid   中间位置
     * @param end   结束位置
     */
    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int index = 0;
        int p1 = start;
        int p2 = mid + 1;
        //比较左右两部分的元素，哪个小，把那个元素填入temp中
        while (p1 <= mid && p2 <= end) {
            temp[index++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        //上面的循环退出后，把剩余的元素依次填入到temp中
        //以下两个while只有一个会执行
        while (p1 <= mid) {
            temp[index++] = nums[p1++];
        }
        while (p2 <= end) {
            temp[index++] = nums[p2++];
        }
        //把最终的排序的结果复制给原数组
        for (index = 0; index < temp.length; index++) {
            nums[start + index] = temp[index];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 7, 9, 5, 8};
        try {
            mergeSort(nums);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i : nums) {
            System.out.print(i + "    ");
        }
    }
}
