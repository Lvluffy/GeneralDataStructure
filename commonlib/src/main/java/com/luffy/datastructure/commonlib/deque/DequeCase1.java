package com.luffy.datastructure.commonlib.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by lvlufei on 2019/11/16
 *
 * @name 双端队列
 * @desc 案例分析：和至少为 K 的最短子数组
 * <p>
 * 题目：返回A的最短的非空连续子数组的长度，该子数组的和至少为 K 。如果没有和至少为 K 的非空子数组，返回 -1 。
 * <p>
 * 示例1：
 * 输入：A = [1], K = 1
 * 输出：1
 * <p>
 * 示例2：
 * 输入：A = [1,2], K = 4
 * 输出：-1
 * <p>
 * 示例3：
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 */
public class DequeCase1 {

    /**
     * 双端队列解法（滑动窗口）
     *
     * @param nums 数组数据
     * @param k    子数组之和
     * @return 满足条件的子数组长度
     */
    public int deque(int[] nums, int k) {
        int length = nums.length;
        // 用数组 p 表示数组 nums 的前缀和。
        long[] p = new long[length + 1];
        for (int i = 0; i < length; ++i) {
            p[i + 1] = p[i] + (long) nums[i];
        }
        // 答案 length + 1 是不可能的。
        int answer = length + 1;
        // 双端队列
        Deque<Integer> deque = new LinkedList();
        for (int y = 0; y < p.length; ++y) {
            while (!deque.isEmpty() && p[y] <= p[deque.getLast()]) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && p[y] >= p[deque.getFirst()] + k) {
                answer = Math.min(answer, y - deque.removeFirst());
            }
            deque.addLast(y);
        }
        return answer < length + 1 ? answer : -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {1, 2};
        int[] nums3 = {2, -1, 2};
        int k1 = 1;
        int k2 = 4;
        int k3 = 3;
        DequeCase1 dequeCase1 = new DequeCase1();
        // 双端队列解法：
        System.out.println("双端队列解法");
        System.out.println("示例1：" + dequeCase1.deque(nums1, k1));
        System.out.println("示例2：" + dequeCase1.deque(nums2, k2));
        System.out.println("示例3：" + dequeCase1.deque(nums3, k3));
    }
}
