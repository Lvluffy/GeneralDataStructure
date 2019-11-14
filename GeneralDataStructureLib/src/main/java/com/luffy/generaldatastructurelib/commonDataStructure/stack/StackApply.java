package com.luffy.generaldatastructurelib.commonDataStructure.stack;

import java.util.Stack;

/**
 * Created by lvlufei on 2019/10/22
 *
 * @name 栈
 * @desc 特点：后进先出
 * <p>
 * 题目：
 * 给定一个只包含'('，')'，'['，']'，'{'，'}'的字符串，判断括号组合是否有效?
 */
public class StackApply {
    /**
     * 判断括号是否成对
     *
     * @param str
     * @return ture-成对；false-不成对
     */
    public static boolean judgeBracketPair(String str) {
        if (str == null || "".equals(str) || str.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(' || c[i] == '[' || c[i] == '{') {
                /*加入栈顶*/
                stack.push(c[i]);
            } else if (c[i] == ')') {
                /*检测栈顶是否存在*/
                if (stack.peek() == '(') {
                    /*从栈中移除*/
                    stack.pop();
                }
            } else if (c[i] == ']') {
                /*检测栈顶是否存在*/
                if (stack.peek() == '[') {
                    /*从栈中移除*/
                    stack.pop();
                }
            } else if (c[i] == '}') {
                /*检测栈顶是否存在*/
                if (stack.peek() == '{') {
                    /*从栈中移除*/
                    stack.pop();
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("是否成对：" + judgeBracketPair("((((({{{{{[[[[[]]]]]}}}}})))))(()){}[]{{[[]]}}"));
        System.out.println("是否成对：" + judgeBracketPair("((((({{{{{[[[[[]]]]]}}}}})))))(()){]}}"));
        System.out.println("是否成对：" + judgeBracketPair(null));
    }
}
