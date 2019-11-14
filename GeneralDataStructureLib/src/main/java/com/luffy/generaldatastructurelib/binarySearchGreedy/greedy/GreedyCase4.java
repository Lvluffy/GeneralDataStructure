package com.luffy.generaldatastructurelib.binarySearchGreedy.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvlufei on 2019/11/14
 *
 * @name 贪婪算法
 * @desc 案例分析：划分字母区间
 * <p>
 * 题目：
 * 字符串S由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例1：
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释：划分结果为 "ababcbaca", "defegde", "hijhklij"。每个字母最多出现在一个片段中。像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * 注意:
 * 1，S的长度在[1, 500]之间。
 * 2，S只包含小写字母'a'到'z'。
 */
public class GreedyCase4 {
    /**
     * 贪婪解法
     *
     * @param str 字符串
     * @return 指定长度数的最大值。
     * <p>
     * 定义数组lastIndex[char]来表示字符char最后一次出现的下标。定义start和end来表示当前区间的首尾。如果遇到的字符最后一次出现的位置下标大于end，
     * 就让end=lastIndex[char]来拓展当前的区间。当遍历到了当前区间的末尾时(即i==end)，把当前区间加入答案，同时将start设为i+1去找下一个区间。
     */
    public static List<Integer> greedy(String str) {
        //答案
        List<Integer> answer = new ArrayList();
        //字符最后一次出现的下标
        int[] lastIndex = new int[26];
        for (int i = 0; i < str.length(); ++i) {
            lastIndex[str.charAt(i) - 'a'] = i;
        }
        //当前区间的首位
        int strat = 0;
        //当前区间的尾位
        int end = 0;
        for (int i = 0; i < str.length(); ++i) {
            end = Math.max(end, lastIndex[str.charAt(i) - 'a']);
            if (i == end) {
                answer.add(i - strat + 1);
                strat = i + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        List<Integer> answer = greedy(str);
        for (int i : answer) {
            System.out.print(i + "  ");
        }
    }
}
