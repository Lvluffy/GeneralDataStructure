package com.luffy.datastructure.leetcodelib.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by lvlufei on 2019/11/6
 *
 * @name 前k个高频元素
 * <p>
 * 题目：给定一个非空的整数数组，返回其中出现频率前k高的元素。
 * 说明：
 * 1，你可以假设给定的k总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 2，你的算法的时间复杂度必须优于O(nlogn), n是数组的大小。
 * 示例：
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class LeetCode_347 {

    /**
     * 队列解法
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> priorityQueue(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Comparator c = new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                return map.get(i).compareTo(map.get(j));
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, c);
        Set<Integer> set = map.keySet();
        for (int key : set) {
            if (queue.size() < k) {//集合没有满，直接放进去
                queue.offer(key);
            } else if (map.get(queue.peek()) < map.get(key)) {//比队列中的最小元素大那么对头出队，放一个到队列中
                queue.poll();
                queue.offer(key);
            }
        }
        for (int i = 0; i < k; i++) {
            //弹出到数组列表
            list.add(queue.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        LeetCode_347 leetCode347 = new LeetCode_347();
        List<Integer> list = leetCode347.priorityQueue(nums, 2);
        for (int i : list) {
            System.out.print(i + "   ");
        }
    }

}
