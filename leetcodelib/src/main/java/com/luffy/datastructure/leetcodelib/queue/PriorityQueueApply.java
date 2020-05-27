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
 * @name 优先队列
 * @desc 特点：保证每次取出的元素是队列中优先级最高的。
 * <p>
 * 优先级别可自定义，例如，数据的数值越大，优先级越高；或者数据的数值越小，优先级越高。优先级甚至可以通过各种复杂的计算得到。
 * <p>
 * 最常用的场景：
 * 从杂乱无章的数据中按照一定的顺序（或者优先级）筛选数据
 * <p>
 * 本质：
 * 二叉堆的结构，利用一个数组结构来实现完全二叉树。
 * <p>
 * 复杂度：O(k+nlogk)
 * <p>
 * 题目：前k个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前k高的元素。
 * 说明：
 * 1，你可以假设给定的k总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 2，你的算法的时间复杂度必须优于O(nlogn), n是数组的大小。
 * 示例：
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class PriorityQueueApply {

    /**
     * 前k个高频
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
        PriorityQueueApply priorityQueueApply = new PriorityQueueApply();
        List<Integer> list = priorityQueueApply.priorityQueue(nums, 2);
        for (int i : list) {
            System.out.print(i + "   ");
        }
    }

}
