package com.luffy.datastructure.leetcodelib.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by lvlufei on 2019/11/7
 *
 * @name 计算右侧小于当前元素的个数
 * <p>
 * 题目：给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
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
 * <p>
 * 解题步骤：
 * 1，从给定数组构建线段树的预处理步骤。
 * 2，修改元素时更新线段树。
 * 3，使用线段树进行区域和检索。
 */
public class LeetCode_315 {

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller(nums));
        System.out.println(fenwickTree(nums));
    }

    /**
     * 数小
     *
     * @param nums 整数数组
     * @return
     */
    public static List<Integer> countSmaller(int[] nums) {
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

    /**
     * 树状数组解法
     *
     * @param nums 数组数据
     * @return
     */
    public static List<Integer> fenwickTree(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // 特判
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        // 使用二分搜索树方便排序
        Set<Integer> set = new TreeSet();
        for (int num1 : nums) {
            set.add(num1);
        }
        // 排名表
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer num : set) {
            map.put(num, rank);
            rank++;
        }
        FenwickTree fenwickTree = new FenwickTree(set.size() + 1);
        // 从后向前填表
        for (int i = len - 1; i >= 0; i--) {
            // 1、查询排名
            rank = map.get(nums[i]);
            // 2、在树状数组排名的那个位置 + 1
            fenwickTree.update(rank, 1);
            // 3、查询一下小于等于“当前排名 - 1”的元素有多少
            res.add(fenwickTree.query(rank - 1));
        }
        Collections.reverse(res);
        return res;
    }

    private static class FenwickTree {
        private int[] tree;
        private int len;

        public FenwickTree(int n) {
            this.len = n;
            tree = new int[n + 1];
        }

        // 单点更新：将 index 这个位置 + 1
        public void update(int i, int delta) {
            // 从下到上，最多到 size，可以等于 size
            while (i <= this.len) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }

        // 区间查询：查询小于等于 index 的元素个数
        // 查询的语义是"前缀和"
        public int query(int i) {
            // 从右到左查询
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= lowbit(i);
            }
            return sum;
        }

        public int lowbit(int x) {
            return x & (-x);
        }
    }
}
