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
 */
public class StackApply {
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

    public static void main(String[] args) {
        String str1 = "()";
        String str2 = "()[]{}";
        String str3 = "(]";
        String str4 = "([)]";
        String str5 = "{[]}";
        StackApply stackApply = new StackApply();
        System.out.println("示例1：" + stackApply.stack(str1));
        System.out.println("示例2：" + stackApply.stack(str2));
        System.out.println("示例3：" + stackApply.stack(str3));
        System.out.println("示例4：" + stackApply.stack(str4));
        System.out.println("示例5：" + stackApply.stack(str5));
        System.out.println("示例6：" + stackApply.stack(null));
    }
}
