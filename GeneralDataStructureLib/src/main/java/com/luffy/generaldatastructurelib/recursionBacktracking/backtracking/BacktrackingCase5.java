package com.luffy.generaldatastructurelib.recursionBacktracking.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by lvlufei on 2019/11/19
 *
 * @name 回溯
 * @desc 案例分析：组合总和
 * <p>
 * 题目：给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明:
 * 1，所有数字（包括 target）都是正整数。
 * 2，解集不能包含重复的组合。
 * <p>
 * 示例1：
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 示例2：
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class BacktrackingCase5 {

    /**
     * 回溯辅助
     *
     * @param candidates
     * @param answer
     * @param target
     * @param start
     * @param pre
     */
    private void backTrackingAuxiliary(int[] candidates, List<List<Integer>> answer, int target, int start, Stack<Integer> pre) {
        if (target == 0) {
            answer.add(new ArrayList<>(pre));
            return;
        }
        // 优化：在循环的时候做判断，尽量避免系统栈的深度
        for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
            pre.add(candidates[i]);
            backTrackingAuxiliary(candidates, answer, target - candidates[i], i, pre);
            pre.pop();
        }
    }

    /**
     * 回溯解法
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> backTracking(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        int len = candidates.length;
        if (len == 0) {
            return answer;
        }
        // 优化：先对数组排序，可以提前终止判断
        Arrays.sort(candidates);
        backTrackingAuxiliary(candidates, answer, target, 0, new Stack<Integer>());
        return answer;
    }

    public static void main(String[] args) {
        int[] candidates1 = {2, 3, 6, 7};
        int[] candidates2 = {2, 3, 5};
        int target1 = 7;
        int target2 = 8;
        BacktrackingCase5 backtrackingCase5 = new BacktrackingCase5();
        System.out.println("示例1：" + backtrackingCase5.backTracking(candidates1, target1));
        System.out.println("示例2：" + backtrackingCase5.backTracking(candidates2, target2));
    }

}
