package com.luffy.datastructure.searchlib.depthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lvlufei on 2019/11/18
 *
 * @name 深度优先搜索
 * @desc 案例分析：朋友圈
 * <p>
 * 题目：班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 * 示例1：
 * 输入:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。第2个学生自己在一个朋友圈。所以返回2。
 * <p>
 * 示例2：
 * 输入:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 */
public class DFSCase1 {

    public static void main(String[] args) {
        int[][] M1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] M2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        // 深度优先搜索解法
        System.out.println("深度优先搜索解法:");
        System.out.println("示例1:" + dfs(M1));
        System.out.println("示例2:" + dfs(M2));
        // 广度优先搜索解法
        System.out.println("广度优先搜索解法:");
        System.out.println("示例1:" + bfs(M1));
        System.out.println("示例2:" + bfs(M2));
    }

    /**
     * 深度优先搜索解法
     * <p>
     * 时间复杂度：O(n^2)，整个矩阵都要被遍历，大小为n^2。
     * 空间复杂度：O(n)，visited 数组的大小。
     *
     * @param M 二维网络数据
     * @return
     */
    public static int dfs(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfsAuxiliary(M, visited, i);
                count++;
            }
        }
        return count;
    }

    /**
     * 深度优先搜索解法-辅助
     *
     * @param m       二维网络数据
     * @param visited
     * @param index   索引
     */
    private static void dfsAuxiliary(int[][] m, int[] visited, int index) {
        for (int j = 0; j < m.length; j++) {
            if (m[index][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfsAuxiliary(m, visited, j);
            }
        }
    }

    /**
     * 广度优先搜索解法
     * <p>
     * 时间复杂度：O(n^2)，整个矩阵都要被访问。
     * 空间复杂度：O(n)，queue和visited数组的大小。
     *
     * @param M 二维网络数据
     * @return
     */
    public static int bfs(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
