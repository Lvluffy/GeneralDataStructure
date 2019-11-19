package com.luffy.generaldatastructurelib.recursionBacktracking.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lvlufei on 2019/11/19
 *
 * @name 回溯
 * @desc 案例分析：全排列
 * <p>
 * 题目：给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例：
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class BacktrackingCase2 {

    /**
     * 回溯辅助
     *
     * @param n
     * @param nums
     * @param output
     * @param first
     */
    public void backTrackingAuxiliary(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
        if (first == n) {
            output.add(new ArrayList<>(nums));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backTrackingAuxiliary(n, nums, output, first + 1);
            Collections.swap(nums, first, i);
        }
    }

    /**
     * 回溯解法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> backTracking(int[] nums) {
        List<List<Integer>> output = new LinkedList();
        ArrayList<Integer> nums_lst = new ArrayList<>();
        for (int num : nums) {
            nums_lst.add(num);
        }
        int n = nums.length;
        backTrackingAuxiliary(n, nums_lst, output, 0);
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        BacktrackingCase2 backtrackingCase2 = new BacktrackingCase2();
        System.out.println(backtrackingCase2.backTracking(nums));
    }
}
