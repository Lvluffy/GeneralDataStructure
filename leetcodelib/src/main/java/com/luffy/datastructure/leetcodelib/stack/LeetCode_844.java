package com.luffy.datastructure.leetcodelib.stack;

import java.util.Stack;

/**
 * Created by lvlufei on 2019/11/15
 *
 * @name 比较含退格的字符串
 * <p>
 * 题目：给定 str1 和 str2 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 示例1：
 * 输入：str1 = "ab#c", str2 = "ad#c"
 * 输出：true
 * 解释：str1 和 str2 都会变成 “ac”。
 * <p>
 * 示例2：
 * 输入：str1 = "ab##", str2 = "c#d#"
 * 输出：true
 * 解释：str1 和 str2 都会变成 “”。
 * <p>
 * 示例3：
 * 输入：str1 = "a##c", str2 = "#a#c"
 * 输出：true
 * 解释：str1 和 str2 都会变成 “c”。
 */
public class LeetCode_844 {
    /**
     * 栈解法
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 二者是否相等，true or false
     */
    public boolean stack(String str1, String str2) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        // 处理str1
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == '#') {
                // 不为空
                if (!stack1.empty()) {
                    // 出栈
                    stack1.pop();
                }
            } else {
                // 压栈
                stack1.push(str1.charAt(i));
            }
        }
        // 处理str2
        for (int j = 0; j < str2.length(); j++) {
            if (str2.charAt(j) == '#') {
                // 不为空
                if (!stack2.empty()) {
                    // 出栈
                    stack2.pop();
                }
            } else {
                // 压栈
                stack2.push(str2.charAt(j));
            }
        }
        if (stack1.size() != stack2.size()) {
            return false;
        }
        while (!stack1.empty()) {
            // 判断是否相等
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1_1 = "ab#c";
        String str1_2 = "ad#c";
        String str2_1 = "ab##";
        String str2_2 = "c#d#";
        String str3_1 = "a##c";
        String str3_2 = "#a#c";
        LeetCode_844 leetCode844 = new LeetCode_844();
        System.out.println("示例1：" + leetCode844.stack(str1_1, str1_2));
        System.out.println("示例2：" + leetCode844.stack(str2_1, str2_2));
        System.out.println("示例3：" + leetCode844.stack(str3_1, str3_2));
    }
}
