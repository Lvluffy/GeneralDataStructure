package com.luffy.generaldatastructurelib.commonDataStructure.stack;

import java.util.Stack;

/**
 * Created by lvlufei on 2019/11/15
 *
 * @name 栈
 * @desc 案例分析：最大矩形
 * <p>
 * 题目：给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例：
 * 输入:
 * [
 * ['1','0','1','0','0'],
 * ['1','0','1','1','1'],
 * ['1','1','1','1','1'],
 * ['1','0','0','1','0']
 * ]
 * 输出: 6
 */
public class StackCase4 {

    /**
     * 栈解法
     *
     * @param nums 数据
     * @return 最大面积
     */
    public int stack(char[][] nums) {
        if (nums.length == 0) return 0;
        // 最大面积
        int maxarea = 0;
        int[] dp = new int[nums[0].length];
        for (char[] num : nums) {
            for (int j = 0; j < nums[0].length; j++) {
                dp[j] = num[j] == '1' ? dp[j] + 1 : 0;
            }
            maxarea = Math.max(maxarea, stackAssist(dp));
        }
        return maxarea;
    }

    /**
     * 栈解法-辅助
     *
     * @param heights
     * @return
     */
    private int stackAssist(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxarea;
    }

    /**
     * 动态规划解法
     *
     * @param nums 数据
     * @return 最大面积
     */
    public int dynamicPlan(char[][] nums) {
        if (nums.length == 0) return 0;
        int maxarea = 0;
        int[][] dp = new int[nums.length][nums[0].length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                    int width = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);
                        maxarea = Math.max(maxarea, width * (i - k + 1));
                    }
                }
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        char[][] nums = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        StackCase4 stackCase4 = new StackCase4();
        // 栈解法
        System.out.println("栈解法:" + stackCase4.stack(nums));
        // 动态规划解法
        System.out.println("栈解法:" + stackCase4.dynamicPlan(nums));
    }
}
