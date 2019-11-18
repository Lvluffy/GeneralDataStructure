package com.luffy.generaldatastructurelib.commonDataStructure.stack;

import java.util.Stack;

/**
 * Created by lvlufei on 2019/11/15
 *
 * @name 栈
 * @desc 案例分析：移掉K位数字
 * <p>
 * 题目：给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意：
 * 1，num 的长度小于 10002 且 ≥ k。
 * 2，num 不会包含任何前导零。
 * <p>
 * 示例1：
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * <p>
 * 示例2：
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * <p>
 * 示例3：
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class StackCase3 {

    /**
     * 贪心解法
     *
     * @param num 字符串
     * @param k   移除k位数字
     * @return 剩下的数字最小值
     */
    public String greedy(String num, int k) {
        //每次都移除峰值，共移除k次，返回结果值即可
        while (k > 0) {
            int index = num.length() - 1;
            //找到第一个num[i]>num[i+1]
            for (int i = 0; i < num.length() - 1; i++)
                if (num.charAt(i) > num.charAt(i + 1)) {
                    index = i;
                    break;
                }
            num = num.substring(0, index).concat(num.substring(index + 1));
            //如果字符串一直升序，则index == num.length()-1,则移除index
            k--;
        }
        while (num.length() > 0 && num.charAt(0) == '0') {
            num = num.substring(1);
        }
        return ("".equals(num)) ? "0" : num;
    }

    /**
     * 栈解法
     *
     * @param num 字符串
     * @param k   移除k位数字
     * @return 剩下的数字最小值
     */
    public String stack(String num, int k) {
        int sum = 0;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int tmp = num.charAt(i) - '0';
            while (!stack1.isEmpty() && stack1.peek() > tmp && sum < k) {
                stack1.pop();
                sum++;
            }
            stack1.add(tmp);
        }
        while (sum < k && !stack1.isEmpty()) {
            sum++;
            stack1.pop();
        }
        StringBuilder answer = new StringBuilder();
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        while (!stack2.isEmpty() && stack2.peek() == 0) {
            stack2.pop();
        }
        while (!stack2.isEmpty()) {
            answer.append(stack2.pop());
        }
        if (answer.length() == 0) {
            answer.append("0");
        }
        return answer.toString();
    }


    public static void main(String[] args) {
        String str1 = "1432219";
        String str2 = "10200";
        String str3 = "10";
        int k1 = 3;
        int k2 = 1;
        int k3 = 2;
        StackCase3 stackCase3 = new StackCase3();
        // 贪心解法
        System.out.println("贪心解法");
        System.out.println("示例1：" + stackCase3.greedy(str1, k1));
        System.out.println("示例2：" + stackCase3.greedy(str2, k2));
        System.out.println("示例3：" + stackCase3.greedy(str3, k3));
        // 栈解法
        System.out.println("栈解法");
        System.out.println("示例1：" + stackCase3.stack(str1, k1));
        System.out.println("示例2：" + stackCase3.stack(str2, k2));
        System.out.println("示例3：" + stackCase3.stack(str3, k3));
    }
}
