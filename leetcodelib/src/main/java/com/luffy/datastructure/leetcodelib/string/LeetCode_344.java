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

    public static void main(String[] args) {
        System.out.println("双指针（while法）:" + reverseString_1("hello"));
        System.out.println("双指针（for循环）:" + reverseString_2("hello"));
        System.out.println("双指针（while法）:" + reverseString_1("Hannah"));
        System.out.println("双指针（for循环）:" + reverseString_2("Hannah"));
    }

    /**
     * 双指针（while法）
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param input
     * @return
     */
    public static String reverseString_1(String input) {
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        char tmp;
        while (left < right) {
            tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return new String(chars);
    }

    /**
     * 双指针（for循环）
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param input
     * @return
     */
    public static String reverseString_2(String input) {
        char[] chars = input.toCharArray();
        for (int left = 0, right = chars.length - 1; left < right; ++left, --right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
        }
        return new String(chars);
    }
}
