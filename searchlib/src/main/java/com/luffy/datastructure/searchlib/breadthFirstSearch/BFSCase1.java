package com.luffy.datastructure.searchlib.breadthFirstSearch;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by lvlufei on 2019/11/18
 *
 * @name 广度优先搜索
 * @desc 案例分析：接雨水
 * <p>
 * 题目：给定一个 m x n 的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * <p>
 * 说明：m 和 n 都是小于110的整数。每一个单位的高度都大于 0 且小于 20000。
 * <p>
 * 示例：
 * 给出如下 3x6 的高度图:
 * [
 * [1,4,3,1,3,2],
 * [3,2,1,3,2,4],
 * [2,3,3,2,3,1]
 * ]
 * 返回 4。
 */
public class BFSCase1 {

    class TrapNode {
        int height;
        int row;
        int col;

        public TrapNode(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }
    }

    /**
     * 广度优先搜索解法
     * <p>
     * 解题思路：
     * 1，先将最外围四周看作第一层围栏，矩阵的元素看作节点，将其添加到优先队列中；
     * 2，依次出队，并进行bfs，过程中维护一个“当前边界最小值”，该值为所有出队的高度中的最大值；
     * 3，在bfs过程中，即访问出队节点的邻居时，若邻居高度小于“当前边界最小值”，则该邻居节点可储水(“当前边界最小值” - 邻居节点高度)
     * 4，需要一个visited矩阵，记录bfs遍历过的节点
     *
     * @param heightMap
     * @return
     */
    public int bfs(int[][] heightMap) {
        int rows = heightMap.length;
        if (rows == 0) {
            return 0;
        }
        int cols = heightMap[0].length;
        int[][] visited = new int[rows][cols];
        Queue<TrapNode> priorityQueue = new PriorityQueue<>(new Comparator<TrapNode>() {
            @Override
            public int compare(TrapNode o1, TrapNode o2) {
                return o1.height - o2.height;
            }
        });
        for (int i = 0; i < rows; i++) {
            priorityQueue.add(new TrapNode(heightMap[i][0], i, 0));
            priorityQueue.add(new TrapNode(heightMap[i][cols - 1], i, cols - 1));
            visited[i][0] = 1;
            visited[i][cols - 1] = 1;
        }
        for (int j = 1; j < cols - 1; j++) {
            priorityQueue.add(new TrapNode(heightMap[0][j], 0, j));
            priorityQueue.add(new TrapNode(heightMap[rows - 1][j], rows - 1, j));
            visited[0][j] = 1;
            visited[rows - 1][j] = 1;
        }
        int currMinBound = Integer.MIN_VALUE;
        int total = 0;
        while (priorityQueue.size() != 0) {
            TrapNode node = priorityQueue.poll();
            currMinBound = Math.max(node.height, currMinBound);
            if (node.row > 0 && visited[node.row - 1][node.col] == 0) {
                priorityQueue.add(new TrapNode(heightMap[node.row - 1][node.col], node.row - 1, node.col));
                visited[node.row - 1][node.col] = 1;
                if (heightMap[node.row - 1][node.col] < currMinBound) {
                    total += (currMinBound - heightMap[node.row - 1][node.col]);
                }
            }
            if (node.row < rows - 1 && visited[node.row + 1][node.col] == 0) {
                priorityQueue.add(new TrapNode(heightMap[node.row + 1][node.col], node.row + 1, node.col));
                visited[node.row + 1][node.col] = 1;
                if (heightMap[node.row + 1][node.col] < currMinBound) {
                    total += (currMinBound - heightMap[node.row + 1][node.col]);
                }
            }
            if (node.col > 0 && visited[node.row][node.col - 1] == 0) {
                priorityQueue.add(new TrapNode(heightMap[node.row][node.col - 1], node.row, node.col - 1));
                visited[node.row][node.col - 1] = 1;
                if (heightMap[node.row][node.col - 1] < currMinBound) {
                    total += (currMinBound - heightMap[node.row][node.col - 1]);
                }
            }
            if (node.col < cols - 1 && visited[node.row][node.col + 1] == 0) {
                priorityQueue.add(new TrapNode(heightMap[node.row][node.col + 1], node.row, node.col + 1));
                visited[node.row][node.col + 1] = 1;
                if (heightMap[node.row][node.col + 1] < currMinBound) {
                    total += (currMinBound - heightMap[node.row][node.col + 1]);
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] n = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        BFSCase1 bfsCase1 = new BFSCase1();
        System.out.println(bfsCase1.bfs(n));
    }
}
