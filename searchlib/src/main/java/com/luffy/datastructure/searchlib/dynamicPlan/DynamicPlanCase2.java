package com.luffy.datastructure.searchlib.dynamicPlan;

/**
 * Created by lvlufei on 2019/11/16
 *
 * @name 动态规划
 * @desc 案例分析：分隔数组以得到最大和
 * <p>
 * 题目：给出整数数组 nums，将该数组分隔为长度最多为 K 的几个（连续）子数组。分隔完成后，每个子数组的中的值都会变为该子数组中的最大值。返回给定数组完成分隔后的最大和。
 * <p>
 * 示例：
 * 输入：nums = [1,15,7,9,2,5,10], K = 3
 * 输出：84
 * 解释：nums 变为 [15,15,15,9,10,10,10]
 * <p>
 * 提示：
 * 1，1 <= K <= nums.length <= 500
 * 2，0 <= nums[i] <= 10^6
 */
public class DynamicPlanCase2 {

    /**
     * 动态规划解法
     * <p>
     * 时间复杂度：O(n*k)
     * 空间复杂度：O(n)
     *
     * @param nums 数组数据
     * @param k    长度最多为K的几个（连续）子数组
     * @return 给定数组完成分隔后的最大和
     */
    public static int dynamicPlan(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            int domainMax = nums[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                domainMax = Math.max(domainMax, nums[i - j + 1]);
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - j] + j * domainMax);
                } else {
                    dp[i] = Math.max(dp[i], j * domainMax);
                }
            }
        }
        return dp[len - 1];
    }


    public static void main(String[] args) {
        int[] nums = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        // 动态规划解法
        System.out.println("动态规划解法:" + dynamicPlan(nums, k));
    }
}
