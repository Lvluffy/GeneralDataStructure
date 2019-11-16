package com.luffy.generaldatastructurelib.commonDataStructure.stack;

import java.util.Stack;

/**
 * Created by lvlufei on 2019/11/15
 *
 * @name 栈
 * @desc 案例分析：去除重复字母
 * <p>
 * 题目：给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 示例1：
 * 输入: "bcabc"
 * 输出: "abc"
 * <p>
 * 示例2：
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 */
public class StackCase5 {

    /**
     * 栈解法
     *
     * @param str 数据
     * @return
     */
    public static String stack(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character character = str.charAt(i);
            if (stack.contains(character)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > character && str.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(character);
        }
        char[] res = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.get(i);
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String str1 = "bcabc";
        String str2 = "cbacdcbc";
        // 栈解法
        System.out.println("栈解法:");
        System.out.println("示例1:" + stack(str1));
        System.out.println("示例2:" + stack(str2));
    }
}
