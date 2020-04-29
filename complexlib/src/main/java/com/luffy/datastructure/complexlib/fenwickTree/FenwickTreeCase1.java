package com.luffy.datastructure.complexlib.fenwickTree;

/**
 * Created by lvlufei on 2019/11/18
 *
 * @name 树状数组
 * @desc 案例分析：区间和的个数
 * <p>
 * 题目：给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * <p>
 * 示例：
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 */
public class FenwickTreeCase1 {

    /**
     * @param nums  数组数据
     * @param lower 左边索引
     * @param upper 右边索引
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        long[] res = new long[nums.length];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 单个数值在所给区间范围
            if (lower <= nums[i] && nums[i] <= upper) {
                count++;
            }
            sum += nums[i];
            res[i] = sum;
        }
        for (int i = 1; i < nums.length; i++) {
            // 从第0个到第i个元素之和在所给区间范围
            if (lower <= res[i] && res[i] <= upper) {
                count++;
            }
            for (int j = 0; j < i - 1; j++) {
                long z = res[i] - res[j];
                // 从第i(i>0)个到第j个元素之和在所给区间范围
                if (lower <= z && z <= upper) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        FenwickTreeCase1 fenwickTreeCase1 = new FenwickTreeCase1();
        System.out.println(fenwickTreeCase1.countRangeSum(nums, -2, 2));
    }
}
