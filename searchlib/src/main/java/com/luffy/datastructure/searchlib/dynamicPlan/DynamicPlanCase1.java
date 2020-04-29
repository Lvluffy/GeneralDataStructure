package com.luffy.datastructure.searchlib.dynamicPlan;

/**
 * Created by lvlufei on 2019/11/14
 *
 * @name 动态规划
 * @desc 案例分析：买卖股票的最佳时机含手续费
 * <p>
 * 题目：你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。返回获得利润的最大值。
 * <p>
 * 示例：
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 */
public class DynamicPlanCase1 {
    /**
     * 动态规划解法
     * <p>
     * 时间复杂度：O(n)，其中n是数组的长度。
     * 空间复杂度：O(1)。
     *
     * @param nums 数组数据
     * @param fee  手续费
     * @return 返回最大利润
     */
    public static int dynamicPlan(int[] nums, int fee) {
        //现金（不持有股票的最大利润）
        int cash = 0;
        //持有股票（持有股票的最大利润）
        int hold = -nums[0];
        //在第i天时，我们需要根据第i−1天的状态来更新cash和hold的值。
        for (int i = 1; i < nums.length; i++) {
            //对于cash，我们可以保持不变，或者将手上的股票卖出。
            cash = Math.max(cash, hold + nums[i] - fee);
            //对于hold，我们可以保持不变，或者买入这一天的股票。
            hold = Math.max(hold, cash - nums[i]);
        }
        return cash;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        //动态规划解法
        System.out.println(dynamicPlan(nums, fee));
    }

}
