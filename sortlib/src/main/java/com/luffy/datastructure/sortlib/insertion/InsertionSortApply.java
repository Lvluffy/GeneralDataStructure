package com.luffy.datastructure.sortlib.insertion;

/**
 * Created by lvlufei on 2019/11/7
 *
 * @name 插入排序
 * @desc 特点：在冒泡排序中，经过每一轮的排序处理后，数组后端的数是排好的；而对于插入排序来说，经过每一轮的排序处理后，数组前段的数是排好序的。
 * <p>
 * 基本思想：不断地将尚未排好序的数插入到已经排好序的部分。
 * <p>
 * 过程：插入排序从小到大排序：首先位置1上的数和位置0上的数进行比较，如果位置1上的数大于位置0上的数，将位置0上的数向后移一位，将1插入到0位置，
 * 否则不处理。位置k上的数和之前的数依次进行比较，如果位置K上的数更大，将之前的数向后移位，最后将位置k上的数插入不满足条件点，反之不处理。
 * <p>
 * 时间复杂度：O(n^2)
 * 1，给定的数组按照顺序已经排好
 * 只需要进行n-1次的比较，两两交换次数为0，时间复杂度是O(n)。这是最好的情况。
 * 2，给定的数组按照逆序排列
 * 在这种情况下，我们需要进行n(n-1)/2次比较，时间复杂度是O(n^2)。这是最坏的情况。
 * 3，给定的数组杂乱无章
 * 在这种情况下，平均时间复杂度是O(n^2)。
 * 空间复杂度：O(1)
 * <p>
 * 题目：给定一个数组[2,1,7,9,5,8]，要求按照从左到右、从小到大的顺序进行排序。
 */
public class InsertionSortApply {
    /**
     * 插入排序
     *
     * @param nums 数组数据
     * @return
     */
    public static int[] insertionSort(int[] nums) throws Exception {
        if (nums == null || nums.length == 0) {
            throw new Exception("参数错误");
        }
        //交换变量
        int temp;
        //定义一个标示
        int i, j;
        for (i = 1; i < nums.length; i++) {
            temp = nums[i];
            //将第I个数组插入到合适的位置
            for (j = i - 1; j >= 0 && nums[j] > temp; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 7, 9, 5, 8};
        try {
            insertionSort(nums);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i : nums) {
            System.out.print(i + "    ");
        }
    }
}
