package com.luffy.datastructure.leetcodelib.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lvlufei on 2019/11/7
 *
 * @name 单词搜索
 * <p>
 * 题目：给定一个二维网格board和一个字典中的单词列表words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 核心思想：DFS + 前缀树
 * <p>
 * 示例:
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ***['o','bothwayLinkedList','bothwayLinkedList','n'],
 * ***['e','t','bothwayLinkedList','e'],
 * ***['i','h','k','r'],
 * ***['i','f','l','v']
 * ]
 * 输出: ["eat","oath"]
 * <p>
 * 说明:
 * 你可以假设所有输入都由小写字母 bothwayLinkedList-z 组成。
 * <p>
 * 提示:
 * 1，你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 2，如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？。
 */
public class LeetCode_79 {

    private TrieNode root = new TrieNode();
    private int[] row = new int[]{-1, 1, 0, 0};
    private int[] col = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        LeetCode_79 leetCode79 = new LeetCode_79();
        List<String> list = leetCode79.findWords(board, words);
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * 查找单词
     *
     * @param board 二维网格
     * @param words 字典中的单词列表
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        //1，直接用list存，会出现重复记录word的情况。
        //2，用HashSet暂存结果，确保不会出现重复word
        HashSet<String> temp = new HashSet<>();
        //前缀树
        for (String word : words) {
            TrieNode node = root;
            for (int j = 0; j < word.length(); j++)
                node = node.add(word.charAt(j));
            node.word = word;
        }
        //DFS（深度优先搜索算法）
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.ifExists(board[i][j])) {
                    find(board, visited, i, j, root, temp);
                }
            }
        }
        //返回结果
        List<String> results = new ArrayList<>();
        results.addAll(temp);
        return results;
    }

    /**
     * 查找
     *
     * @param board   二维网格
     * @param visited 是否被访问
     * @param x
     * @param y
     * @param node    前缀树
     * @param temp
     */
    private void find(char[][] board, boolean[][] visited, int x, int y, TrieNode node, HashSet<String> temp) {
        visited[x][y] = true;
        TrieNode cur = node.next[board[x][y] - 'a'];
        //到达可匹配子串，记录当前 word
        if (cur.word != null)
            temp.add(cur.word);
        for (int i = 0; i < 4; i++) {
            int x2 = x + row[i];
            int y2 = y + col[i];
            if (x2 >= 0 && x2 < board.length && y2 >= 0 && y2 < board[0].length && !visited[x2][y2]) {
                if (cur.ifExists(board[x2][y2])) {
                    find(board, visited, x2, y2, cur, temp);
                }
            }
        }
        visited[x][y] = false;
    }

    /**
     * 前缀树
     */
    class TrieNode {
        String word;
        TrieNode[] next = new TrieNode[26];

        TrieNode add(char chr) {
            if (next[chr - 'a'] != null)
                return next[chr - 'a'];
            next[chr - 'a'] = new TrieNode();
            return next[chr - 'a'];
        }

        boolean ifExists(char chr) {
            return next[chr - 'a'] != null;
        }
    }
}
