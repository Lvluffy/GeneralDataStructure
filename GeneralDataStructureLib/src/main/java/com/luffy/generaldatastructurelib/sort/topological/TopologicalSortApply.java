package com.luffy.generaldatastructurelib.sort.topological;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by lvlufei on 2019/11/8
 *
 * @name 拓扑排序
 * @desc --
 * <p>
 * 基本思想：
 * 拓扑排序应用的场合不再是一个简单的数组，而是研究图论里面顶点和顶点连线之间的性质。拓扑排序就是要将这些顶点按照相连的性质进行排序。
 * 要实现拓扑排序，需有有几个前提：
 * 1，图必须是有向的
 * 2，图里面没有环
 * <p>
 * 拓扑排序一般用来清理具有依赖关系的任务。
 * <p>
 * 实现：
 * 1，将问题用一个有向无环图进行抽象表达，定义出哪些是图的顶点，顶点之间如何相关联。
 * 2，可以利用广度优先搜索或深度优先搜索进行拓扑排序。
 * <p>
 * 时间复杂度：O(n)
 * 统计顶点的入度需要O(n)的时间，接下来每一个顶点被遍历一次，同样需要O(n)的时间，所有拓扑排序的时间复杂度是O(n)。
 * <p>
 * 题目：课程表
 * 有一个学生想要修完5门课程的学分，这5门课程分别用0、1、2、3、4来表示，现在已知学习这些课有如下要求：
 * 1，课程1和3依赖于课程0
 * 2，课程2依赖于课程1和3
 * 3，课程3依赖于课程0和1
 * 4，课程5依赖于课程2和3
 * 那么这个学生应该按照怎样的顺序来学习这5门课程呢？
 */
public class TopologicalSortApply {

    /**
     * 拓扑排序
     *
     * @param numCourses    总共课程
     * @param prerequisites 先决条件
     * @return
     */
    public static int[] topologicalSort(int numCourses, int[][] prerequisites) {
        //先处理极端情况
        if (numCourses <= 0) {
            return new int[0];
        }
        //邻接表
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        //入度表
        int[] inDegree = new int[numCourses];
        //遍历prerequisites的时候，把邻接表和入度表都填上
        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            //当前入度为0的结点
            Integer inDegreeNode = queue.removeFirst();
            //加入结果集中
            res.add(inDegreeNode);
            //下面从图中删去
            //得到所有的后继课程，接下来把它们的入度全部减去1
            HashSet<Integer> nextCourses = graph[inDegreeNode];
            for (Integer nextCourse : nextCourses) {
                inDegree[nextCourse]--;
                //马上检测该结点的入度是否为0，如果为0，马上加入队列
                if (inDegree[nextCourse] == 0) {
                    queue.addLast(nextCourse);
                }
            }
        }
        //如果结果集中的数量不等于结点的数量，就不能完成课程任务，这一点是拓扑排序的结论
        int resLen = res.size();
        if (resLen == numCourses) {
            int[] ret = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ret[i] = res.get(i);
            }
            return ret;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {3, 0}, {2, 1}, {2, 3}, {3, 1}, {4, 2}, {4, 3}};
        int[] result = topologicalSort(5, prerequisites);
        for (int i : result) {
            System.out.print(i + "    ");
        }
    }
}
