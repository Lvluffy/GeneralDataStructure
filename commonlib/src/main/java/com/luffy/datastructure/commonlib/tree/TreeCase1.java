package com.luffy.datastructure.commonlib.tree;

/**
 * Created by lvlufei on 2019/11/18
 *
 * @name 树
 * @desc 案例分析：二叉树中的最大路径和
 * <p>
 * 题目：给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例1:
 * 输入: [1,2,3]
 * --1
 * -/ \
 * 2   3
 * 输出: 6
 * <p>
 * 示例2:
 * 输入: [-10,9,20,null,null,15,7]
 * ～～～-10
 * ～～～/ \
 * ～～9  20
 * ～～～～/ \
 * ～～～15  7
 * 输出: 42
 */
public class TreeCase1 {

    /**
     * 树节点
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max_sum = Integer.MIN_VALUE;

    public int getMaxRootSum(TreeNode root) {
        if (root == null) return 0;
        // 节点的和小于0 则舍弃 重置为0
        int left = Math.max(getMaxRootSum(root.left), 0);
        //节点的和小于0 则舍弃 重置为0
        int right = Math.max(getMaxRootSum(root.right), 0);
        //每次和最大值进行对比，保存最大值
        max_sum = Math.max(max_sum, root.val + left + right);
        //当前节点的最大值等于左边和右边的最大值加上当前节点
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        getMaxRootSum(root);
        return max_sum;
    }
}
