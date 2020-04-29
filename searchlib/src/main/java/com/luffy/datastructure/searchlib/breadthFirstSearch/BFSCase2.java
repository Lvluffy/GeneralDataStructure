package com.luffy.datastructure.searchlib.breadthFirstSearch;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by lvlufei on 2019/11/18
 *
 * @name 广度优先搜索
 * @desc 案例分析：公交路线
 * <p>
 * 题目：我们有一系列公交路线。每一条路线 routes[i] 上都有一辆公交车在上面循环行驶。例如，有一条路线 routes[0] = [1, 5, 7]，表示第一辆 (下标为0) 公交车会一直按照 1->5->7->1->5->7->1->... 的车站路线行驶。
 * 假设我们从 S 车站开始（初始时不在公交车上），要去往 E 站。 期间仅可乘坐公交车，求出最少乘坐的公交车数量。返回 -1 表示不可能到达终点车站。
 * <p>
 * 示例:
 * 输入:
 * routes = [[1, 2, 7], [3, 6, 7]]
 * S = 1
 * E = 6
 * 输出: 2
 * 解释:
 * 最优策略是先乘坐第一辆公交车到达车站 7, 然后换乘第二辆公交车到车站 6。
 * <p>
 * 说明：
 * 1，1 <= routes.length <= 500
 * 2，1 <= routes[i].length <= 500
 * 3，0 <= routes[i][j] < 10 ^ 6
 */
public class BFSCase2 {

    /**
     * 广度优先搜索解法
     *
     * @param routes 线路
     * @param strat  起始点
     * @param end    终点
     * @return
     */
    public int bfs(int[][] routes, int strat, int end) {
        if (strat == end) return 0;
        int N = routes.length;
        List<List<Integer>> graph = new ArrayList();
        for (int[] route : routes) {
            Arrays.sort(route);
            graph.add(new ArrayList());
        }
        // 初始化 可见、队列、目标
        Set<Integer> seen = new HashSet();
        Set<Integer> targets = new HashSet();
        Queue<Point> queue = new ArrayDeque();
        // 构建图表。如果两个公共汽车共享至少一个公共汽车站，则它们是连接的。
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (intersect(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        // 可见表示节点是否已加入队列。
        // 队列处理广度优先搜索。
        // 目标是我们拥有的一组目标状态。
        for (int i = 0; i < N; ++i) {
            if (Arrays.binarySearch(routes[i], strat) >= 0) {
                seen.add(i);
                queue.offer(new Point(i, 0));
            }
            if (Arrays.binarySearch(routes[i], end) >= 0) {
                targets.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Point info = queue.poll();
            int node = info.x, depth = info.y;
            if (targets.contains(node)) return depth + 1;
            for (Integer nei : graph.get(node)) {
                if (!seen.contains(nei)) {
                    seen.add(nei);
                    queue.offer(new Point(nei, depth + 1));
                }
            }
        }
        return -1;
    }

    /**
     * 是否相交
     *
     * @param A
     * @param B
     * @return
     */
    public boolean intersect(int[] A, int[] B) {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) return true;
            if (A[i] < B[j]) i++;
            else j++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        int start = 1;
        int end = 6;
        BFSCase2 bfsCase2 = new BFSCase2();
        System.out.println(bfsCase2.bfs(routes, start, end));
    }
}
