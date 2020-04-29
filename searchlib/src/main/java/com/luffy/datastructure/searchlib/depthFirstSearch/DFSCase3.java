package com.luffy.datastructure.searchlib.depthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lvlufei on 2019/11/18
 *
 * @name 深度优先搜索
 * @desc 案例分析：树中距离之和
 * <p>
 * 题目：给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。第 i 条边连接节点 edges[i][0] 和 edges[i][1]。返回一个表示节点 i 与其他所有节点距离之和的列表 ans。
 * <p>
 * 示例：
 * 输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * 输出: [8,12,6,10,10,10]
 * 解释:
 * 如下为给定的树的示意图：
 * --0
 * -/ \
 * 1   2
 * ---/|\
 * --3 4 5
 * <p>
 * 我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * 也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-distances-in-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DFSCase3 {

    int[] ans;// ans[x] 表示节点 x 距离树中其它节点的距离之和.
    int[] count;
    List<Set<Integer>> graph;
    int N;

    /**
     * 深度优先搜索解法
     *
     * @param N     节点数量
     * @param edges 边的连接节点
     * @return
     */
    public int[] dfs(int N, int[][] edges) {
        this.N = N;
        graph = new ArrayList<>();
        ans = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);
        for (int i = 0; i < N; ++i) {
            graph.add(new HashSet<Integer>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfsAuxiliary1(0, -1);
        dfsAuxiliary2(0, -1);
        return ans;
    }

    /**
     * 深度优先搜索解法-辅助1
     *
     * @param node   节点
     * @param parent 父节点
     */
    private void dfsAuxiliary1(int node, int parent) {
        for (int child : graph.get(node))
            if (child != parent) {
                dfsAuxiliary1(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
    }

    /**
     * 深度优先搜索解法-辅助1
     *
     * @param node   节点
     * @param parent 父节点
     */
    private void dfsAuxiliary2(int node, int parent) {
        for (int child : graph.get(node))
            if (child != parent) {
                ans[child] = ans[node] - count[child] + N - count[child];
                dfsAuxiliary2(child, node);
            }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};

        DFSCase3 dfsCase3 = new DFSCase3();
        int[] answer = dfsCase3.dfs(n, edges);
        for (int i : answer) {
            System.out.print(i + "    ");
        }

    }
}
