package com.luffy.datastructure.leetcodelib.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lvlufei on 2021-02-23
 *
 * @name 二叉树的层序遍历
 * <p>
 * 题目：给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * 二叉树：[1,2,3,4,5,6,7]
 *
 *         1
 *       /   \
 *      2     3
 *     / \   / \
 *    4  5  6  7
 *
 * 返回其层序遍历结果：
 * [
 *   [1],
 *   [2,3],
 *   [4,5,6,7]
 * ]
 */
public class LeetCode_102 {

    public static void main(String[] args) {
        //根节点
        TreeNode root = new TreeNode(1);

        //左边节点
        TreeNode left = new TreeNode(2);
        TreeNode left_1 = new TreeNode(4);
        TreeNode right_1 = new TreeNode(5);
        left.left = left_1;
        left.right = right_1;

        //右边节点
        TreeNode right = new TreeNode(3);
        TreeNode left_2 = new TreeNode(6);
        TreeNode right_2 = new TreeNode(7);
        right.left = left_2;
        right.right = right_2;

        root.left = left;
        root.right = right;

        System.out.println(levelPrint_1(root));
        System.out.println(levelPrint_2(root));
    }

    /**
     * 层级打印
     * <p>
     * 时间复杂度：O(n)。
     * 空间复杂度：O(n)。
     *
     * @param root
     * @return
     */
    public static List<Integer> levelPrint_1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            result.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return result;
    }

    /**
     * 层级打印
     * <p>
     * 时间复杂度：O(n)。
     * 空间复杂度：O(n)。
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelPrint_2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                temp = queue.poll();
                level.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
