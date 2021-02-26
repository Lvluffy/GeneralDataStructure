package com.luffy.datastructure.leetcodelib.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lvlufei on 2021-02-26
 *
 * @name 二叉树的最大深度
 * <p>
 * 题目：给定一个二叉树，找出其最大深度。
 * <p>
 * 示例：
 * 给定二叉树 [1,2,3,null,null,6,7]，
 *
 *     1
 *    / \
 *   2  3
 *     /  \
 *    6   7
 *
 * 返回它的最大深度 3 。
 */
public class LeetCode_104 {

    public static void main(String[] args) {
        //根节点
        TreeNode root = new TreeNode(1);

        //左边节点
        TreeNode left = new TreeNode(2);

        //右边节点
        TreeNode right = new TreeNode(3);
        TreeNode left_2 = new TreeNode(6);
        TreeNode right_2 = new TreeNode(7);
        right.left = left_2;
        right.right = right_2;

        root.left = left;
        root.right = right;

        System.out.println("深度优先搜索:" + maxDepth_1(root));
        System.out.println("广度优先搜索:" + maxDepth_2(root));
    }

    /**
     * 深度优先搜索
     * <p>
     * 时间复杂度：O(n)，其中 n 为二叉树节点的个数。每个节点在递归中只被遍历一次。
     * 空间复杂度：O(height)，其中 height 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。
     *
     * @param root
     * @return
     */
    public static int maxDepth_1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth_1(root.left);
            int rightHeight = maxDepth_1(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * 广度优先搜索
     * <p>
     * 时间复杂度：O(n)，其中 n 为二叉树的节点个数。与方法一同样的分析，每个节点只会被访问一次。
     * 空间复杂度：O(n)。
     *
     * @param root
     * @return
     */
    public static int maxDepth_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            result++;
        }
        return result;
    }
}
