package com.luffy.datastructure.searchlib.depthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lvlufei on 2019/11/18
 *
 * @name 深度优先搜索
 * @desc 案例分析：岛屿数量
 * <p>
 * 题目：给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例1：
 * 输入:
 * [[1,1,1,1,0]
 * [1,1,0,1,0]
 * [1,1,0,0,0]
 * [0,0,0,0,0]]
 * 输出: 1
 * <p>
 * 示例2：
 * 输入:
 * [[1,1,0,0,0]
 * [1,1,0,0,0]
 * [0,0,1,0,0]
 * [0,0,0,1,1]]
 * 输出: 3
 */
public class DFSCase2 {

    /**
     * 深度优先搜索解法-辅助
     *
     * @param grid 二维网络数据
     * @param row  行
     * @param col  列
     */
    private void dfsAuxiliary(int[][] grid, int row, int col) {
        int n_row = grid.length;
        int n_col = grid[0].length;
        if (row < 0 || col < 0 || row >= n_row || col >= n_col || grid[row][col] == 0) {
            return;
        }
        grid[row][col] = 0;
        dfsAuxiliary(grid, row - 1, col);
        dfsAuxiliary(grid, row + 1, col);
        dfsAuxiliary(grid, row, col - 1);
        dfsAuxiliary(grid, row, col + 1);
    }

    /**
     * 深度优先搜索解法
     * <p>
     * 时间复杂度：O(M×N)，其中 M 和 N 分别为行数和列数。
     * 空间复杂度：最坏情况下为 O(M×N)，此时整个网格均为陆地，深度优先搜索的深度达到 M×N。
     *
     * @param grid 二维网络数据
     * @return
     */
    public int dfs(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n_row = grid.length;
        int n_col = grid[0].length;
        int num_islands = 0;
        for (int row = 0; row < n_row; ++row) {
            for (int col = 0; col < n_col; ++col) {
                if (grid[row][col] == 1) {
                    ++num_islands;
                    dfsAuxiliary(grid, row, col);
                }
            }
        }
        return num_islands;
    }

    /**
     * 广度优先搜索解法
     * <p>
     * 时间复杂度：O(M×N)，其中 M 和 N 分别为行数和列数。
     * 空间复杂度：O(min(M,N))，在最坏的情况下（全部为陆地），队列的大小可以达到 min(M，N)。
     *
     * @param grid 二维网络数据
     * @return
     */
    public int bfs(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n_row = grid.length;
        int n_col = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < n_row; ++r) {
            for (int c = 0; c < n_col; ++c) {
                if (grid[r][c] == 1) {
                    ++num_islands;
                    grid[r][c] = 0;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(r * n_col + c);
                    while (!queue.isEmpty()) {
                        int id = queue.remove();
                        int row = id / n_col;// 行
                        int col = id % n_col;// 列
                        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                            queue.add((row - 1) * n_col + col);
                            grid[row - 1][col] = 0;
                        }
                        if (row + 1 < n_row && grid[row + 1][col] == 1) {
                            queue.add((row + 1) * n_col + col);
                            grid[row + 1][col] = 0;
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                            queue.add(row * n_col + col - 1);
                            grid[row][col - 1] = 0;
                        }
                        if (col + 1 < n_col && grid[row][col + 1] == 1) {
                            queue.add(row * n_col + col + 1);
                            grid[row][col + 1] = 0;
                        }
                    }
                }
            }
        }
        return num_islands;
    }

    public static void main(String[] args) {
        int[][] M1_1 = {{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int[][] M1_2 = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        int[][] M2_1 = {{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int[][] M2_2 = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        DFSCase2 dfsCase2 = new DFSCase2();
        // 深度优先搜索解法
        System.out.println("深度优先搜索解法:");
        System.out.println("示例1:" + dfsCase2.dfs(M1_1));
        System.out.println("示例2:" + dfsCase2.dfs(M1_2));
        // 广度优先搜索解法
        System.out.println("广度优先搜索解法:");
        System.out.println("示例1:" + dfsCase2.bfs(M2_1));
        System.out.println("示例2:" + dfsCase2.bfs(M2_2));
    }
}
