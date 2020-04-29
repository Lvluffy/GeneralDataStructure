package com.luffy.datastructure.searchlib.greedy;

import java.util.Arrays;

/**
 * Created by lvlufei on 2019/11/12
 *
 * @name 贪婪算法
 * @desc --
 * <p>
 * 基本思想：
 * 贪心算法的基本思路是从问题的某一个初始解出发一步一步地进行，根据某个优化测度，每一步都要确保能获得局部最优解。每一步只考虑一个数据，
 * 他的选取应该满足局部优化的条件。若下一个数据和部分最优解连在一起不再是可行解时，就不把该数据添加到部分解中，直到把所有数据枚举完，或者不能再添加算法停止。
 * <p>
 * 过程：
 * 1，建立数学模型来描述问题；
 * 2，把求解的问题分成若干个子问题；
 * 3，对每一子问题求解，得到子问题的局部最优解；
 * 4，把子问题的解局部最优解合成原来解问题的一个解。
 * <p>
 * 特点：
 * 1，随着算法的进行，将积累起其它两个集合：一个包含已经被考虑过并被选出的候选对象，另一个包含已经被考虑过但被丢弃的候选对象。
 * 2，有一个函数来检查一个候选对象的集合是否提供了问题的解答。该函数不考虑此时的解决方法是否最优。
 * 3，还有一个函数检查是否一个候选对象的集合是可行的，也即是否可能往该集合上添加更多的候选对象以获得一个解。和上一个函数一样，此时不考虑解决方法的最优性。
 * 4，选择函数可以指出哪一个剩余的候选对象最有希望构成问题的解。
 * 5，最后，目标函数给出解的值。
 * 6，为了解决问题，需要寻找一个构成解的候选对象集合，它可以优化目标函数，贪婪算法一步一步的进行。起初，算法选出的候选对象的集合为空。
 * 接下来的每一步中，根据选择函数，算法从剩余候选对象中选出最有希望构成解的对象。如果集合中加上该对象后不可行，那么该对象就被丢弃并不再考虑；
 * 否则就加到集合里。每一次都扩充集合，并检查该集合是否构成解。如果贪婪算法正确工作，那么找到的第一个解通常是最优的。
 * <p>
 * 优缺点：
 * 优点：对于一些问题，非常直观有效。
 * 缺点：
 * 1，并不是所有问题都能用它去解决。
 * 2，得到的结果并不一定不是正确的，因为这种算法容易过早的得出决定，从而没有办法达到最优解。
 * <p>
 * 题目：会议室
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，
 * 同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 * <p>
 * 示例：
 * 输入: [[0, 30],[5, 10],[15, 20]]
 * 输出: 2
 */
public class GreedyApply {

    /**
     * 最小会议室
     *
     * @param nums
     * @return
     */
    public int minMeetingRooms(int[][] nums) {
        if (nums == null || nums.length == 0) return 0;
        //开始时间、结束时间
        int[] startTime = new int[nums.length];
        int[] endTime = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            startTime[i] = nums[i][0];
            endTime[i] = nums[i][1];
        }
        //时间排序
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        //安排会议室
        int rooms = 0;
        int i = 0;
        int j = 0;
        while (i < nums.length && j < nums.length) {
            if (startTime[i] < endTime[j]) {
                rooms++;
                i++;
            } else {
                rooms--;
                j++;
            }
        }
        return rooms;

    }

    public static void main(String[] args) {
        int[][] nums = {{0, 30}, {5, 10,}, {15, 20}};
        GreedyApply greedyApply = new GreedyApply();
        int rooms = greedyApply.minMeetingRooms(nums);
        System.out.println(rooms);
    }
}
