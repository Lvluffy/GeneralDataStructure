package com.luffy.datastructure.leetcodelib.stack;

import java.util.Stack;

/**
 * Created by lvlufei on 2019/11/6
 *
 * @name 栈
 * @desc 案例分析：每日温度
 * <p>
 * 题目：根据每日气温列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用0来代替。
 * <p>
 * 示例：
 * 输入：temperatures = [73, 74, 75, 71, 69, 72, 76, 73]。
 * 输出：[1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温列表长度的范围是[1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class StackCase2 {
    /**
     * 栈解法
     * <p>
     * 时间复杂度：O(n)。其中n是数组的长度，每个索引最多做一次压栈和出栈的操作。
     * 空间复杂度：O(m)
     *
     * @param nums 数组数据（每日气温列表）
     * @return 等待多久温度才会升高超过该日的天数
     */
    public int[] stack(int[] nums) {
        int[] anwser = new int[nums.length];
        Stack<Integer> stack = new Stack();
        for (int i = nums.length - 1; i >= 0; --i) {
            // 如果栈顶有值，并且栈顶的数值 > 当前数值，则将栈顶数值移除栈。
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                // 移除栈
                stack.pop();
            }
            anwser[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            // 加入栈顶
            stack.push(i);
        }
        return anwser;
    }

    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        StackCase2 stackCase2 = new StackCase2();
        int[] anwser = stackCase2.stack(nums);
        for (int i : anwser) {
            System.out.print(i + "    ");
        }
    }
}
