package com.luffy.datastructure.searchlib.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvlufei on 2019/11/19
 *
 * @name 回溯
 * @desc 案例分析：括号生成
 * <p>
 * 题目：给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 示例：
 * 输入: n = 3
 * 输出:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class BacktrackingCase3 {

    public static void main(String[] args) {
        int n = 3;
        BacktrackingCase3 backtrackingCase3 = new BacktrackingCase3();
        System.out.println(backtrackingCase3.backTracking(n));
    }

    /**
     * 回溯解法
     * <p>
     * 解题思路：
     * 1，只有在我们知道序列仍然保持有效时才添加 '(' or ')'。我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
     * 2，如果我们还剩一个位置，我们可以开始放一个左括号。 如果它不超过左括号的数量，我们可以放一个右括号。
     *
     * @param n
     * @return
     */
    public List<String> backTracking(int n) {
        List<String> answer = new ArrayList();
        backTrackingAuxiliary(answer, "", 0, 0, n);
        return answer;
    }

    /**
     * 回溯辅助
     *
     * @param answer
     * @param cur
     * @param open
     * @param close
     * @param max
     */
    public void backTrackingAuxiliary(List<String> answer, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            answer.add(cur);
            return;
        }
        if (open < max) {
            backTrackingAuxiliary(answer, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backTrackingAuxiliary(answer, cur + ")", open, close + 1, max);
        }
    }
}
