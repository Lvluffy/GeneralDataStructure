package com.luffy.datastructure.leetcodelib.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lvlufei on 2021-02-23
 *
 * @name 二叉树的中序遍历
 * <p>
 * 题目：给你一个二叉树，返回它的 中序 遍历
 * <p>
 * 示例：
 * 二叉树：[1,2,3,4,5,6]
 *
 *         1
 *       /   \
 *      2     3
 *     / \   / \
 *    4  5  6  7
 *
 * 返回其层序遍历结果：[4,2,5,1,6,3,7]
 */
public class LeetCode_94 {

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

        System.out.println("递归法:" + inorderTraversal_1(root));
        System.out.println("迭代法:" + inorderTraversal_2(root));
    }

    /**
     * 递归法
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal_1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * 迭代法
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal_2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
