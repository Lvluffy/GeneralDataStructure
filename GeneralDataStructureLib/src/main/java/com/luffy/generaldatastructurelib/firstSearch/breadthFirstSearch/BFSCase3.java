package com.luffy.generaldatastructurelib.firstSearch.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lvlufei on 2019/11/18
 *
 * @name 广度优先搜索
 * @desc 案例分析：访问所有节点的最短路径
 * <p>
 * 题目：给出 graph 为有 N 个节点（编号为 0, 1, 2, ..., N-1）的无向连通图。 graph.length = N，且只有节点 i 和 j 连通时，j != i 在列表 graph[i] 中恰好出现一次。
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 * <p>
 * 示例1：
 * 输入：[[1,2,3],[0],[0],[0]]
 * 输出：4
 * 解释：一个可能的路径为 [1,0,2,0,3]
 * <p>
 * 示例2：
 * 输入：[[1],[0,2,4],[1,3,4],[2],[1,2]]
 * 输出：4
 * 解释：一个可能的路径为 [0,1,4,2,3]
 */
public class BFSCase3 {
    /**
     * 广度优先搜索解法
     *
     * @param graph 图（二维网络）
     * @return
     */
    public int bfs(int[][] graph) {
        int len = graph.length;
        if (graph == null || graph.length == 0) {
            return 0;
        }
        // 标记是否访问过,用于避免重复访问
        boolean[][] visited = new boolean[len][1 << len];
        // 用于检查是否访问完所有的节点,每个位代表一个节点的状态,形如1111
        int finishState = (1 << len) - 1;
        // 队列里的数组,第一个记录的是标号,第二个是状态
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            queue.offer(new int[]{i, 1 << i});
        }
        // 答案
        int answer = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] node = queue.poll();
                // 如果标记的节点访问状态是结束,那么返回步长
                if (finishState == node[1]) {
                    return answer;
                }
                for (int next : graph[node[0]]) {
                    // 2个节点相或,标记着访问了这条边的2个点
                    int nextState = node[1] | (1 << next);
                    if (visited[next][nextState]) {
                        continue;
                    }
                    visited[next][nextState] = true;
                    // 将该节点和边的信息加入bfs对列
                    queue.offer(new int[]{next, nextState});
                }
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] graph1 = {{1, 2, 3}, {0}, {0}, {0}};
        int[][] graph2 = {{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}};
        BFSCase3 bfsCase3 = new BFSCase3();
        System.out.println("示例1：" + bfsCase3.bfs(graph1));
        System.out.println("示例2：" + bfsCase3.bfs(graph2));
    }
}
