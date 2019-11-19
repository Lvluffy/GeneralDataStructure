package com.luffy.generaldatastructurelib.recursionBacktracking.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvlufei on 2019/11/19
 *
 * @name 回溯
 * @desc 案例分析：电话号码的字母组合
 * <p>
 * 题目：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射与电话按键相同。注意 1 不对应任何字母。
 * 2=a,b,c
 * 3=d,e,f
 * 4=g,h,i
 * 5=j,k,l
 * 6=m,n,o
 * 7=p,q,r,s
 * 8=t,u,v
 * 9=w,x,y,z
 * <p>
 * 示例：
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 说明:尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * ]
 */
public class BacktrackingCase4 {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    /**
     * 回溯辅助
     *
     * @param answer
     * @param combination
     * @param next_digits
     */
    public void backTrackingAuxiliary(List<String> answer, String combination, String next_digits) {
        if (next_digits.length() == 0) {
            answer.add(combination);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backTrackingAuxiliary(answer, combination + letter, next_digits.substring(1));
            }
        }
    }

    /**
     * 回溯解法
     *
     * @param digits
     * @return
     */
    public List<String> backTracking(String digits) {
        List<String> answer = new ArrayList();
        if (digits.length() == 0) {
            return answer;
        }
        backTrackingAuxiliary(answer, "", digits);
        return answer;
    }

    public static void main(String[] args) {
        String digits = "23";
        BacktrackingCase4 backtrackingCase4 = new BacktrackingCase4();
        System.out.println(backtrackingCase4.backTracking(digits));
    }
}
