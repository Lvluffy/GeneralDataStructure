package com.luffy.datastructure.leetcodelib.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lvlufei on 2021-02-23
 *
 * @name 二叉树的后序遍历
 * <p>
 * 题目：给定一个二叉树，返回它的 后序 遍历。
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
 * 返回其层序遍历结果：[4,5,2,6,7,3,1]
 */
public class LeetCode_145 {

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

        System.out.println(postorderTraversal_1(root));
        System.out.println(postorderTraversal_2(root));
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
    public static List<Integer> postorderTraversal_1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public static void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
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
    public static List<Integer> postorderTraversal_2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = null;
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if (root.right == null || root.right == node) {
                result.add(root.val);
                node = root;
                root = null;
            } else {
                deque.push(root);
                root = root.right;
            }
        }
        return result;
    }
}
