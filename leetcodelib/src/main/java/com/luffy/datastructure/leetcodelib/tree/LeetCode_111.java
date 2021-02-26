package com.luffy.datastructure.leetcodelib.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lvlufei on 2021-02-26
 *
 * @name 二叉树的最小深度
 * <p>
 * 题目：给定一个二叉树，找出其最小深度。
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
 * 返回它的最小深度 2 。
 */
public class LeetCode_111 {

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

        System.out.println("深度优先搜索:" + minDepth_1(root));
        System.out.println("广度优先搜索:" + minDepth_2(root));
    }

    /**
     * 深度优先搜索
     * <p>
     * 时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
     * 空间复杂度：O(H)，其中 H 是树的高度。空间复杂度主要取决于递归时栈空间的开销，
     * 最坏情况下，树呈现链状，空间复杂度为 O(N)。
     * 平均情况下树的高度与节点数的对数正相关，空间复杂度为 O(logN)。
     *
     * @param root
     * @return
     */
    public static int minDepth_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int result = Integer.MAX_VALUE;
        if (root.left != null) {
            result = Math.min(minDepth_1(root.left), result);
        }
        if (root.right != null) {
            result = Math.min(minDepth_1(root.right), result);
        }
        return result + 1;
    }

    /**
     * 广度优先搜索
     * <p>
     * 时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
     * 空间复杂度：O(N)，其中 N 是树的节点数。空间复杂度主要取决于队列的开销，队列中的元素个数不会超过树的节点数。
     *
     * @param root
     * @return
     */
    public static int minDepth_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }
        return 0;
    }

    static class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }

        @Override
        public boolean equals(Object o) {
            return super.equals(o);
        }
    }
}
