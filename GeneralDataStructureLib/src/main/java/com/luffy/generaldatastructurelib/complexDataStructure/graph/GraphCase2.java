package com.luffy.generaldatastructurelib.complexDataStructure.graph;

import java.util.LinkedList;

/**
 * Created by lvlufei on 2019/11/16
 *
 * @name 图
 * @desc 案例分析：课程表
 * <p>
 * 题目：现在你总共有n门课需要选，记为0到 n-1。在选修某些课程之前需要一些先修课程。
 * 例如，想要学习课程0，你需要先完成课程1，我们用一个匹配来表示他们: [0,1]，给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * <p>
 * 示例1：
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * <p>
 * 示例2：
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * <p>
 * 说明：输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。你可以假定输入的先决条件中没有重复的边。
 * <p>
 * 提示：
 * 1，这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 2，通过DFS进行拓扑排序。
 * 3，拓扑排序也可以通过BFS完成。
 */
public class GraphCase2 {

    /**
     * 广度优先搜索解法
     * <p>
     * 算法流程：
     * 1，统计课程安排图中每个节点的入度，生成入度表 indegrees。
     * 2，借助一个队列 queue，将所有入度为 0 的节点入队。
     * 3，当queue非空时，依次将队首节点出队，在课程安排图中删除此节点pre：
     * 3-1，并不是真正从邻接表中删除此节点pre，而是将此节点对应所有邻接节点cur的入度 −1，即 indegrees[cur] -= 1。
     * 3-2，当入度−1后邻接节点cur的入度为0，说明cur所有的前驱节点已经被“删除”，此时将cur入队。
     * 4，在每次 pre 出队时，执行 numCourses--；
     * 4-1，若整个课程安排图是有向无环图（即可以安排），则所有节点一定都入队并出队过，即完成拓扑排序。换个角度说，若课程安排图中存在环，一定有节点的入度始终不为0。
     * 4-2，因此，拓扑排序出队次数等于课程个数，返回numCourses==0判断课程是否可以成功安排。
     * <p>
     * 时间复杂度：O(N+M)，遍历一个图需要访问所有节点和所有临边，N和M分别为节点数量和临边数量。
     * 空间复杂度：O(N)，为建立邻接矩阵所需额外空间。
     *
     * @param numCourses    课程数
     * @param prerequisites 先决条件
     * @return
     */
    public static boolean bfs(int numCourses, int[][] prerequisites) {
        // 生成入度表
        int[] indegrees = new int[numCourses];
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
        }
        // 借助一个队列 queue，将所有入度为 0 的节点入队。
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.addLast(i);
        }
        // 当queue非空时，依次将队首节点出队，在课程安排图中删除此节点pre
        while (!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            // 在每次 re 出队时，执行 numCourses--
            numCourses--;
            for (int[] req : prerequisites) {
                if (req[1] != pre) continue;
                if (--indegrees[req[0]] == 0) queue.add(req[0]);
            }
        }
        return numCourses == 0;
    }

    /**
     * 深度优先搜索解法
     * <p>
     * 算法流程：（思路是通过 DFS 判断图中是否有环）
     * 1，借助一个标志列表 flags，用于判断每个节点 i （课程）的状态：
     * 1-1，未被 DFS 访问：i == 0；
     * 1-2，已被其他节点启动的DFS访问：i == -1；
     * 1-3，已被当前节点启动的DFS访问：i == 1。
     * 2，对 numCourses 个节点依次执行 DFS，判断每个节点起步 DFS 是否存在环，若存在环直接返回 False。DFS 流程；
     * 2-1，终止条件：
     * 2-1-1，当 flag[i] == -1，说明当前访问节点已被其他节点启动的 DFS 访问，无需再重复搜索，直接返回 True。
     * 2-1-2，当 flag[i] == 1，说明在本轮 DFS 搜索中节点 i 被第 2 次访问，即 课程安排图有环，直接返回 False。
     * 2-2，将当前访问节点 i 对应 flag[i] 置 1，即标记其被本轮 DFS 访问过；
     * 2-3，递归访问当前节点 i 的所有邻接节点 j，当发现环直接返回 False；
     * 2-4，当前节点所有邻接节点已被遍历，并没有发现环，则将当前节点 flag 置为 −1 并返回 True。
     * 3，若整个图 DFS 结束并未发现环，返回 True。
     * <p>
     * 时间复杂度：O(N+M)，遍历一个图需要访问所有节点和所有临边，N和M分别为节点数量和临边数量。
     * 空间复杂度：O(N)，为建立邻接矩阵所需额外空间。
     *
     * @param numCourses    课程数
     * @param prerequisites 先决条件
     * @return
     */
    public static boolean dfs(int numCourses, int[][] prerequisites) {
        int[][] adjacency = new int[numCourses][numCourses];
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites)
            adjacency[cp[1]][cp[0]] = 1;
        for (int i = 0; i < numCourses; i++) {
            if (!dfsAuxiliary(adjacency, flags, i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 深度优先搜索-辅助
     *
     * @param adjacency
     * @param flags
     * @param i
     * @return
     */
    private static boolean dfsAuxiliary(int[][] adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (int j = 0; j < adjacency.length; j++) {
            if (adjacency[i][j] == 1 && !dfsAuxiliary(adjacency, flags, j)) {
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisites1 = {{1, 0}};
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        int numCourses1 = 2;
        int numCourses2 = 2;
        // 广度优先搜索解法
        System.out.println("广度优先搜索解法：");
        System.out.println("示例1：" + bfs(numCourses1, prerequisites1));
        System.out.println("示例2：" + bfs(numCourses2, prerequisites2));
        // 深度优先搜索解法
        System.out.println("深度优先搜索解法：");
        System.out.println("示例1：" + dfs(numCourses1, prerequisites1));
        System.out.println("示例2：" + dfs(numCourses2, prerequisites2));
    }
}
