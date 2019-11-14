package com.luffy.generaldatastructurelib.binarySearchGreedy.greedy;

import java.util.Stack;

/**
 * Created by lvlufei on 2019/11/14
 *
 * @name 贪婪算法
 * @desc 案例分析：分割平衡字符串
 * <p>
 * 题目：在一个「平衡字符串」中，'L'和'R'字符的数量是相同的。给出一个平衡字符串str，请你将它分割成尽可能多的平衡字符串。返回可以通过分割得到的平衡字符串的最大数量。
 * <p>
 * 示例1：
 * 输入：str = "RLRRLLRLRL"
 * 输出：4
 * 解释：str可以分割为"RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的'L'和'R'。
 * <p>
 * 示例2：
 * 输入：str = "RLLLLRRRLR"
 * 输出：3
 * 解释：str可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * <p>
 * 示例3：
 * 输入：str = "LLLLRRRR"
 * 输出：1
 * 解释：str只能保持原样 "LLLLRRRR".
 */
public class GreedyCase2 {

    /**
     * 贪婪解法
     *
     * @param str 平衡字符串
     * @return 可以通过分割得到的平衡字符串的最大数量
     */
    public static int greedy(String str) {
        int number = 0;//记录数量
        int result = 0;//结果
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'L') {
                number++;
            } else {
                number--;
            }
            if (number == 0) {
                result++;
            }
        }
        return result;
    }

    /**
     * 栈解法
     *
     * @param str 平衡字符串
     * @return 可以通过分割得到的平衡字符串的最大数量
     */
    public static int stack(String str) {
        Stack<Character> stack = new Stack<>();//开辟一个栈空间，用来记录
        int result = 0;//结果
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //如果检测栈是空的，或者栈顶存在指定字符，就加入栈顶；否则从栈中移除
            if (stack.isEmpty() || c == stack.peek()) {
                stack.push(c);
            } else {
                stack.pop();
            }
            //如果检测栈是空的，结果数量自加
            if (stack.isEmpty()) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str1 = "RLRRLLRLRL";
        String str2 = "RLLLLRRRLR";
        String str3 = "LLLLRRRR";
        //贪婪解法
        System.out.println("贪婪解法");
        System.out.println("示例1：" + greedy(str1));
        System.out.println("示例2：" + greedy(str2));
        System.out.println("示例3：" + greedy(str3));
        //栈解法
        System.out.println("栈解法");
        System.out.println("示例1：" + stack(str1));
        System.out.println("示例2：" + stack(str2));
        System.out.println("示例3：" + stack(str3));
    }
}
