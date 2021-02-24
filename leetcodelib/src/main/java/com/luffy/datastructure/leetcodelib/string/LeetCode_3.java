package com.luffy.datastructure.leetcodelib.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lvlufei on 2019/11/15
 *
 * @name 无重复字符的最长字串
 * <p>
 * 题目：给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * 示例1：
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例2：
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例3：
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LeetCode_3 {

    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";
        // 双向链表（滑动窗口）解法
        System.out.println("示例1：" + bothwayLinkedList(str1));
        System.out.println("示例1：" + bothwayLinkedList(str2));
        System.out.println("示例1：" + bothwayLinkedList(str3));
    }

    /**
     * 双向链表（滑动窗口）解法
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度（HashMap）：O(min(m,n))
     * 空间复杂度（Table）：O(m)，m是字符集的大小。
     *
     * @param str 字符串
     * @return 不含有重复字符的最长子串的长度。
     */
    public static int bothwayLinkedList(String str) {
        int anwser = 0;
        // 定义一个map数据结构存储(k, v)，其中key值为字符，value值为字符位置+1，加1表示从字符位置后一个才开始不重复。
        Map<Character, Integer> map = new HashMap<>();
        // 开始位置（stratIndex）；结束位置（endIndex）
        for (int stratIndex = 0, endIndex = 0; endIndex < str.length(); endIndex++) {
            if (map.containsKey(str.charAt(endIndex))) {
                stratIndex = Math.max(map.get(str.charAt(endIndex)), stratIndex);
            }
            anwser = Math.max(anwser, endIndex - stratIndex + 1);
            map.put(str.charAt(endIndex), endIndex + 1);
        }
        return anwser;
    }
}
