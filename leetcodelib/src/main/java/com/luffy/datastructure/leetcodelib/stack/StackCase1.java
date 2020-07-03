package com.luffy.datastructure.leetcodelib.stack;

import java.util.Stack;

/**
 * Created by lvlufei on 2019/10/22
 *
 * @name 栈
 * @desc 特点：先进后出，后进先出。
 * <p>
 * 核心方法讲解：
 * 1，push()：压栈
 * 2，pop()：出栈
 * 3，peek()：获取栈顶的数据
 * 4，empty()：判断栈是否为空
 * <p>
 * 题目：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 1，左括号必须用相同类型的右括号闭合。
 * 2，左括号必须以正确的顺序闭合。
 * <p>
 * 注意：空字符串可被认为是有效字符串。
 * <p>
 * 示例1：
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例2：
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例3：
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例4：
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例5：
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 解题思路：
 * 1，遇见左字符，将左字符入栈
 * 2，遇见右字符
 * 【】如果栈是空的，说明括号无效
 * 【】如果栈不为空，将栈顶字符出栈，与右字符匹配
 * 《》如果左右字符不匹配，说明括号无效
 * 《》如果左右字符匹配，继续扫描下一个字符
 * 3，所有字符扫描完毕
 * 【】栈为空，说明括号有效
 * 【】栈不为空，说明括号无效
 */
public class StackCase1 {
    /**
     * 栈解法
     *
     * @param str 字符串
     * @return 判断括号是否成对（ture-成对；false-不成对）
     */
    public boolean stack(String str) {
        if (str == null || "".equals(str) || str.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] c = str.toCharArray();
        for (char aC : c) {
            if (aC == '(' || aC == '[' || aC == '{') {
                /*加入栈顶*/
                stack.push(aC);
            } else if (aC == ')') {
                /*检测栈顶是否存在*/
                if (stack.peek() == '(') {
                    /*从栈中移除*/
                    stack.pop();
                }
            } else if (aC == ']') {
                /*检测栈顶是否存在*/
                if (stack.peek() == '[') {
                    /*从栈中移除*/
                    stack.pop();
                }
            } else if (aC == '}') {
                /*检测栈顶是否存在*/
                if (stack.peek() == '{') {
                    /*从栈中移除*/
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }

    /**
     * 通过String自带函数（性能太差）
     *
     * @param str
     * @return
     */
    public boolean isValidString(String str) {
        if (str.contains("()") || str.contains("[]") || str.contains("{}")) {
            str = str.replace("()", "");
            str = str.replace("[]", "");
            str = str.replace("{}", "");
        }
        return str.isEmpty();
    }

    /**
     * 通过栈
     *
     * @param str
     * @return
     */
    public boolean isValidStack(String str) {
        if (str == null || "".equals(str) || str.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char left = stack.pop();
                if (left == '(' && c != ')') return false;
                if (left == '[' && c != ']') return false;
                if (left == '{' && c != '}') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str1 = "()";
        String str2 = "()[]{}";
        String str3 = "(]";
        String str4 = "([)]";
        String str5 = "{[]}";
        String str6 = "";
        StackCase1 stackCase1 = new StackCase1();
        System.out.println("示例1：" + stackCase1.isValidString(str1));
        System.out.println("示例2：" + stackCase1.isValidString(str2));
        System.out.println("示例3：" + stackCase1.isValidString(str3));
        System.out.println("示例4：" + stackCase1.isValidString(str4));
        System.out.println("示例5：" + stackCase1.isValidString(str5));
        System.out.println("示例6：" + stackCase1.isValidString(str6));
    }
}
