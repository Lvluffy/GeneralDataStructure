package com.luffy.generaldatastructurelib.complexDataStructure.segmentTree;

/**
 * Created by lvlufei on 2019/11/18
 *
 * @name 线段树
 * @desc 案例分析：区域和检索 - 数组可修改
 * <p>
 * 题目：给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 * <p>
 * 示例：
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * <p>
 * 说明:
 * 1，数组仅可以在 update 函数下进行修改。
 * 2，你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 */
public class SegmentTreeCase1 {
    int[] tree;
    int n;

    public SegmentTreeCase1(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }

    /**
     * 构建线段树
     *
     * @param nums
     */
    private void buildTree(int[] nums) {
        for (int i = n, j = 0; i < 2 * n; i++, j++) {
            tree[i] = nums[j];
        }
        for (int i = n - 1; i > 0; --i) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    /**
     * 更新线段树
     * <p>
     * 当我们更新数组中某个索引 i 处的元素时，我们需要重建线段树，因为一些树节点上的和值也会随之产生变化。我们将再次使用自下而上的方法。
     * 首先更新存储 a[i] 元素的叶节点。从那里我们将一路向上，直到根节点，并用其子节点值的总和来更新每个父节点的值。
     *
     * @param pos
     * @param val
     */
    public void update(int pos, int val) {
        pos += n;
        tree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            // 父节点在子节点更新之后更新
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }

    /**
     * 计算总和
     *
     * @param l 左边界
     * @param r 右边界
     * @return
     */
    public int sumRange(int l, int r) {
        // 左边界的树叶
        l += n;
        // 右边界的树叶
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
                sum += tree[l];
                l++;
            }
            if ((r % 2) == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        SegmentTreeCase1 segmentTreeCase1 = new SegmentTreeCase1(nums);
        System.out.println("sumRange(0,2) = " + segmentTreeCase1.sumRange(0, 2));
        segmentTreeCase1.update(1, 2);
        System.out.println("update(1,2)");
        System.out.println("sumRange(0,2) = " + segmentTreeCase1.sumRange(0, 2));
    }

}
