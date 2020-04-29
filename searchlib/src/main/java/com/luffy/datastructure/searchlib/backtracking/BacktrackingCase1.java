package com.luffy.datastructure.searchlib.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lvlufei on 2019/11/19
 *
 * @name 回溯
 * @desc 案例分析：划分为k个相等的子集
 * <p>
 * 题目：给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例：
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * <p>
 * 注意:
 * 1，1 <= k <= len(nums) <= 16
 * 2，0 < nums[i] < 10000
 */
public class BacktrackingCase1 {

    /**
     * 回溯解法
     *
     * @param nums 数组数据
     * @param k    正整数
     * @return
     */
    public boolean backTracking(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        for (int j : nums) {
            sum += j;
            if (max < j) {
                max = j;
            }
        }
        //总和不能被子集数整除，肯定不存在
        if (sum % k != 0) {
            return false;
        }
        int z = sum / k;
        //子集平均和小于最大值，肯定不存在
        if (z < max) {
            return false;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList();
        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(nums[i]);
        }
        return check(list, 0, k, z);
    }

    private boolean check(List<Integer> list, int sum, int count, int target) {
        if (count == 0) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            if (sum + list.get(i) == target) {
                int temp = list.remove(i);
                if (check(list, 0, count - 1, target)) {
                    return true;
                } else {
                    list.add(i, temp);
                }
            } else if (sum + list.get(i) < target) {
                int temp = list.remove(i);
                if (check(list, sum + temp, count, target)) {
                    return true;
                } else {
                    list.add(i, temp);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        BacktrackingCase1 backtrackingCase1 = new BacktrackingCase1();
        System.out.println(backtrackingCase1.backTracking(nums, k));
    }
}
