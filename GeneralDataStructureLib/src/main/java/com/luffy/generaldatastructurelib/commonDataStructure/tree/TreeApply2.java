package com.luffy.generaldatastructurelib.commonDataStructure.tree;

import java.io.File;
import java.io.IOException;

/**
 * Created by lvlufei on 2019/11/6
 *
 * @name 树的应用
 * @desc 树的特点：结构直观。通过树问题来考察"递归算法"掌握的熟练程度。
 * 树的形状：普通二叉树、平衡二叉树、完全二叉树、四叉树、多叉树、特殊的树（红黑树、白平衡二叉搜索树）
 * 树的考察：树的遍历、树的序列化
 * 树的遍历：前序遍历（Preorder Traversal）、中序遍历（Inoeder Traversal）、后序遍历（Postoder Traversal）
 * 前序遍历：先访问根节点，然后访问左子树，最后访问右子树。
 * 中序遍历：先访问左子树，然后访问根节点，最后访问右子树。常用的场景：二叉搜索树。
 * 后序遍历：先访问左子树，然后访问右子树，最后访问根节点。
 * <p>
 * 题目：遍历文件夹
 */
public class TreeApply2 {
    /**
     * 遍历文件夹
     *
     * @param dir 目录
     */
    public static void traverseFolder(File dir) throws IOException {
        if (!dir.exists()) {
            System.out.println("目录不存在");
            return;
        }
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的");
                return;
            }
            for (File file : files) {
                if (file.isDirectory()) {
                    //递归
                    traverseFolder(file);
                } else {
                    System.out.println("文件：" + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("文件：" + dir.getAbsolutePath());
        }
    }
}
