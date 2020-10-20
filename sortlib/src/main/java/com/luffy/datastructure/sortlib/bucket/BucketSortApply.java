package com.luffy.datastructure.sortlib.bucket;

/**
 * Created by lvlufei on 2019/11/11
 *
 * @name 桶排序
 * @desc --
 * <p>
 * 基本思想：桶排序是体现了分治的思想。
 * <p>
 * 原理：创建若干个桶，通过某种映射将待排序的元素放置到桶中，使每个桶中的最大值都小于他后面一个桶的最小值，并且每个桶容纳的元素数量尽可能平均。然后对每个桶中的元素排序。最后将所有桶中的元素依次输出。
 * <p>
 * 过程：桶排序是计数排序的变种，把计数排序中相邻的m个”小桶”放到一个”大桶”中，在分完桶后，对每个桶进行排序（一般用快排），然后合并成最后的结果。
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * <p>
 * 题目：给定一个数组[2,1,7,9,5,8]，要求按照从左到右、从小到大的顺序进行排序。
 */
public class BucketSortApply {
    /**
     * 桶排序
     *
     * @param nums 数组数据
     * @return
     */
    public static int[] bucketSort1(int[] nums) throws Exception {
        if (nums == null || nums.length < 2) {
            throw new Exception("参数错误");
        }
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] bucket = new int[max + 1];
        for (int num : nums) {
            bucket[num]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                nums[i++] = j;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 7, 9, 5, 8};
        try {
            bucketSort1(nums);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i : nums) {
            System.out.print(i + "    ");
        }
    }
}
