package com.luffy.generaldatastructurelib.commonDataStructure.arrayString;

/**
 * Created by lvlufei on 2019/11/15
 *
 * @name 字符串
 * @desc 案例分析：最长回文子串
 * <p>
 * 题目：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class StringCase2 {

    /**
     * 动态规划解法
     * <p>
     * 时间复杂度：O(n^2)。
     * 空间复杂度：O(n^2)。二维dp问题，一个状态得用二维有序数对表示，因此空间复杂度是O(n^2)。
     *
     * @param str 字符串
     * @return 最长的回文子串
     */
    public static String dynamicPlan(String str) {
        // 如果最多只有一个字符，就返回。
        int len = str.length();
        if (len <= 1) {
            return str;
        }
        // 初始化结果，默认为第一个字符。
        String result = str.substring(0, 1);
        // 最长的回文
        int longestPalindrome = 1;
        // 如果 dp[l,r]= true，那么dp[l + 1,r - 1]也一定为true；关键在这里：[l + 1,r - 1]一定至少有2个元素才有判断的必要，
        // 因为如果[l + 1,r - 1]只有一个元素，不用判断，一定是回文串；如果[l + 1,r - 1]表示的区间为空，不用判断，也一定是回文串。
        // [l + 1, r - 1]一定至少有2个元素，等价于l + 1 < r - 1，即 r - l >  2
        boolean[][] dp = new boolean[len][len];
        // 左边界一定要比右边界小，因此右边界从 1 开始
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (str.charAt(l) == str.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > longestPalindrome) {
                        longestPalindrome = r - l + 1;
                        result = str.substring(l, r + 1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str1 = "babad";
        String str2 = "cbbd";
        System.out.println("示例1：" + dynamicPlan(str1));
        System.out.println("示例2：" + dynamicPlan(str2));
    }

}
