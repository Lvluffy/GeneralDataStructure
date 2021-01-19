package com.luffy.datastructure.leetcodelib.string;

/**
 * Created by lvlufei on 2021-01-19
 *
 * @name 反转字符串
 * <p>
 * 输入：hello     输出：olleh
 * <p>
 * 输入：Hannah    输出：hannaH
 */
public class LeetCode_344 {

    /**
     * 双指针
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param input
     * @return
     */
    public static String reverseString(String input) {
        char[] chars = input.toCharArray();
        for (int left = 0, right = chars.length - 1; left < right; ++left, --right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
        System.out.println(reverseString("Hannah"));
    }
}
