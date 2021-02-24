package com.luffy.datastructure.leetcodelib.string;

/**
 * Created by lvlufei on 2019/11/15
 *
 * @name 编辑距离
 * <p>
 * 题目：给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * 1，插入一个字符
 * 2，删除一个字符
 * 3，替换一个字符
 * <p>
 * 示例1：
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * 示例2：
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class LeetCode_72 {

    public static void main(String[] args) {
        String word1_1 = "horse";
        String word1_2 = "ros";
        String word2_1 = "intention";
        String word2_2 = "execution";
        System.out.println("示例1：" + dynamicPlan(word1_1, word1_2));
        System.out.println("示例2：" + dynamicPlan(word2_1, word2_2));
    }

    /**
     * 动态规划解法
     *
     * @param word1 单词1
     * @param word2 单词2
     * @return 最少操作数
     */
    public static int dynamicPlan(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        // 第一个单词是空的情况
        if (n1 * n2 == 0) {
            return n1 + n2;
        }
        // 定义一个数组，存储转换历史记录。
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 初始化边界
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }
        // 动态规划计算
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[n1][n2];
    }
}
