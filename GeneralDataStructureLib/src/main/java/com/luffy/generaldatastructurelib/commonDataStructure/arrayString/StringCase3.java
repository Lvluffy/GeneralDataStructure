package com.luffy.generaldatastructurelib.commonDataStructure.arrayString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvlufei on 2019/11/15
 *
 * @name 字符串
 * @desc 案例分析：复原IP地址
 * <p>
 * 题目：给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例1：
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 解题思路
 * 1，因为ip固定是4个数字，每个数字的长度范围是1-3。所以取第1个数字的时候，计算后面长度，可以缩小范围。
 * 2，处理最后1个数字时，要直接取到字符串最后一位。
 * 3，IP中每个数字的范围是0-255，注意使用stoi转换时“01”也是可以转换成1的，可以考虑再转回来与字符串对比排除。
 * 4，取得这一位的合法数字后，递归调用取下一位。
 */
public class StringCase3 {
    /**
     * 回溯解法
     *
     * @param str IP地址
     * @param pos 当前扫描到的str的位置
     * @param cur 当前答案
     * @param ans 最终答案
     */
    private static void backtracking(String str, int pos, List<String> cur, List<String> ans) {
        if (cur.size() >= 4) {
            if (pos == str.length()) ans.add(String.join(".", cur));
            return;
        }
        // 分割得到IP地址的一段后，下一段只能在长度1-3范围内选择
        for (int i = 1; i <= 3; i++) {
            if (pos + i > str.length()) {
                break;
            }
            // 剪枝
            String segment = str.substring(pos, pos + i);
            // 剪枝条件：不能以0开头，不能大于255
            if (segment.startsWith("0") && segment.length() > 1 || (i == 3 && Integer.parseInt(segment) > 255)) {
                continue;
            }
            cur.add(segment);
            // 注意此处传的参数
            backtracking(str, pos + i, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }

    /**
     * 还原IP地址
     *
     * @param str IP地址
     * @return
     */
    public static List<String> restoreIpAddresses(String str) {
        List<String> ans = new ArrayList<>();
        backtracking(str, 0, new ArrayList<String>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        String str = "25525511135";
        List<String> answers = restoreIpAddresses(str);
        for (String answer : answers) {
            System.out.println(answer);
        }
    }

}
