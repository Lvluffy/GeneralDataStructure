package com.luffy.generaldatastructurelib.complexDataStructure.graph;

/**
 * Created by lvlufei on 2019/11/7
 *
 * @name 图
 * @desc --
 * <p>
 * 图的存储和表达方式：邻接矩阵、邻接链表
 * <p>
 * 图的遍历：深度优先搜索算法-DFS（Depth-First-Search）、广度优先搜索算法-BFS（Breadth-First-Search）
 * <p>
 * 二部图的检测、树的检测、环的检测：有向图、无向图
 * <p>
 * 题目：判断二分图
 * 给定一个无向图graph，当这个图为二分图时返回true。
 * <p>
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 * <p>
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 * <p>
 * 注意：
 * 1，graph 的长度范围为 [1, 100]。
 * 2，graph[i] 中的元素的范围为 [0, graph.length - 1]。
 * 3，graph[i] 不会包含 i 或者有重复的值。
 * 4，图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。
 * <p>
 * 示例1：
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 * <p>
 * 示例2：
 * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 输出: false
 * 解释:
 * 无向图如下:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * 我们不能将节点分割成两个独立的子集。
 */
public class GraphApply1 {

    /**
     * 判断二分图
     *
     * @param graph
     * @return
     */
    public static boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int color[] = new int[len];
        for (int i = 0; i < len; i++) {
            if (color[i] == 0 && dfs(i, color, 2, graph) == false)
                return false;
        }
        return true;
    }

    /**
     * DFS（深度优先搜索算法）
     *
     * @param i
     * @param color
     * @param t
     * @param graph
     * @return
     */
    private static boolean dfs(int i, int[] color, int t, int[][] graph) {
        if (color[i] != 0)
            return color[i] == t;
        color[i] = t;
        for (int j : graph[i]) {
            if (dfs(j, color, 3 - t, graph) == false)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(isBipartite(graph));
    }
}
