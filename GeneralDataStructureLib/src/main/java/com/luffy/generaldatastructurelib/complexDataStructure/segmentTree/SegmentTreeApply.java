package com.luffy.generaldatastructurelib.complexDataStructure.segmentTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lvlufei on 2019/11/7
 *
 * @name 线段树
 * @desc 特点：是一种按照二叉树的形式存储数据的结构，每个节点保存的都是数组里某一段的总和。
 * <p>
 * 适用：适用于数据很多，而且需要频繁更新并求和的操作；以用于解决多种范围查询问题，比如在对数时间内从数组中找到最小值、最大值、总和、最大公约数、最小公倍数等。
 * <p>
 * 解题步骤：
 * 1，从给定数组构建线段树的预处理步骤。
 * 2，修改元素时更新线段树。
 * 3，使用线段树进行区域和检索。
 * <p>
 * 题目：计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * <p>
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 */
public class SegmentTreeApply {
    /**
     * 数小
     *
     * @param nums 整数数组
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        //排序数组
        List<Integer> temp = new ArrayList<>();
        //结果数组
        Integer[] res = new Integer[nums.length];
        //原数组从后向前遍历，根据二分法升序插入到新数组
        for (int i = nums.length - 1; i >= 0; i--) {
            int left = 0, right = temp.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (temp.get(mid) >= nums[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            //新数组对应位置的下标即为原数组右侧小于该数的个数
            res[i] = left;
            temp.add(left, nums[i]);
        }
        return Arrays.asList(res);
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        SegmentTreeApply segmentTreeApply = new SegmentTreeApply();
        List<Integer> list = segmentTreeApply.countSmaller(nums);
        for (Integer i : list) {
            System.out.println(i + "");
        }
    }
}
