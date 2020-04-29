package com.luffy.datastructure.searchlib.greedy;

/**
 * Created by lvlufei on 2019/11/14
 *
 * @name 贪婪算法
 * @desc 案例分析：分糖果
 * <p>
 * 题目：老师想给孩子们分发糖果，有N个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 1，每个孩子至少分配到 1 个糖果。
 * 2，相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例1：
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * <p>
 * 示例2：
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class GreedyCase3 {
    /**
     * 贪婪解法
     *
     * @param nums 数组数据
     * @return 准备的糖果数量
     */
    public int greedy(int[] nums) {
        int number = nums.length;//数量
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                number++;
            }
        }
        return number;
    }

    /**
     * 动态规划解法
     * <p>
     * 正向和反向各遍历一次求每个孩子应得的糖果
     *
     * @param nums 数组数据
     * @return 准备的糖果数量
     */
    public int dynamicPlan(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return 1;
        //从左往右
        int[] left = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        //从右往左
        int[] right = new int[len];
        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        //合并，取各子项的最大值
        int[] meger = new int[len];
        for (int i = 0; i < len; i++) {
            meger[i] = Math.max(left[i], right[i]);
        }
        //计算总和
        int number = 0;
        for (int aMeger : meger) {
            number += aMeger;
        }
        return number;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0, 2};
        int[] nums2 = {1, 2, 2};
        GreedyCase3 greedyCase3 = new GreedyCase3();
        //贪婪解法
        System.out.println("示例1：" + greedyCase3.greedy(nums1));
        System.out.println("示例2：" + greedyCase3.greedy(nums2));
        //动态规划
        System.out.println("示例1：" + greedyCase3.dynamicPlan(nums1));
        System.out.println("示例2：" + greedyCase3.dynamicPlan(nums2));
    }
}
