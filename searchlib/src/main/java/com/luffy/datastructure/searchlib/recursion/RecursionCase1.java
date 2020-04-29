package com.luffy.datastructure.searchlib.recursion;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by lvlufei on 2019/11/19
 *
 * @name 递归
 * @desc 案例分析：原子的数量
 * <p>
 * 题目：给定一个化学式formula（作为字符串），返回每种原子的数量。
 * <p>
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 * <p>
 * 示例1：
 * 输入:formula = "H2O"
 * 输出: "H2O"
 * 解释:
 * 原子的数量是 {'H': 2, 'O': 1}。
 * <p>
 * 示例2：
 * 输入:formula = "Mg(OH)2"
 * 输出: "H2MgO2"
 * 解释:
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 * <p>
 * 示例3：
 * 输入:formula = "K4(ON(SO3)2)2"
 * 输出: "K4N2O14S4"
 * 解释:
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 * <p>
 * 注意：
 * 1，所有原子的第一个字母为大写，剩余字母都是小写。
 * 2，formula的长度在[1, 1000]之间。
 * 3，formula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。
 */
public class RecursionCase1 {

    int i;

    /**
     * 递归解法
     * <p>
     * 时间复杂度：O(n^2)。n指的是化学式的长度。
     * 空间复杂度：O(n)
     * <p>
     * 算法：
     * 1，编写一个方法 parse 来解析化学式，返回一个由原子名称映射到原子个数的哈希表 count。
     * 2，将把 i 设为全局变量：在调用 parse 函数中递增 i。
     * 3，当遇到 '('，则解析括号内的内容（直到括号结束），并将其添加到计数中。
     * 4，否则，则应该遇到一个大写字符：我们将解析其余的字母以获得名称，并在哈希表中添加该字符（若表中存在则增加计数）。
     * 5，最终，我们将乘以括号系数以得到最终结果。
     *
     * @param formula
     * @return
     */
    public String recursion(String formula) {
        StringBuilder ans = new StringBuilder();
        i = 0;
        Map<String, Integer> count = parse(formula);
        for (String name : count.keySet()) {
            ans.append(name);
            int multiplicity = count.get(name);
            if (multiplicity > 1) {
                ans.append("").append(multiplicity);
            }
        }
        return new String(ans);
    }

    public Map<String, Integer> parse(String formula) {
        int len = formula.length();
        Map<String, Integer> count = new TreeMap();
        while (i < len && formula.charAt(i) != ')') {
            if (formula.charAt(i) == '(') {
                i++;
                for (Map.Entry<String, Integer> entry : parse(formula).entrySet()) {
                    count.put(entry.getKey(), count.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            } else {
                int iStart = i++;
                while (i < len && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < len && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplicity = iStart < i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                count.put(name, count.getOrDefault(name, 0) + multiplicity);
            }
        }
        int iStart = ++i;
        while (i < len && Character.isDigit(formula.charAt(i))) {
            i++;
        }
        if (iStart < i) {
            int multiplicity = Integer.parseInt(formula.substring(iStart, i));
            for (String key : count.keySet()) {
                count.put(key, count.get(key) * multiplicity);
            }
        }
        return count;
    }

    /**
     * 栈解法
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     *
     * @param formula
     * @return
     */
    public String stack(String formula) {
        int len = formula.length();
        Stack<Map<String, Integer>> stack = new Stack();
        stack.push(new TreeMap());
        for (int i = 0; i < len; ) {
            if (formula.charAt(i) == '(') {
                stack.push(new TreeMap());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                int iStart = ++i, multiplicity = 1;
                while (i < len && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                if (i > iStart) {
                    multiplicity = Integer.parseInt(formula.substring(iStart, i));
                }
                for (String c : top.keySet()) {
                    int v = top.get(c);
                    stack.peek().put(c, stack.peek().getOrDefault(c, 0) + v * multiplicity);
                }
            } else {
                int iStart = i++;
                while (i < len && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < len && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplicity = i > iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String name : stack.peek().keySet()) {
            ans.append(name);
            int multiplicity = stack.peek().get(name);
            if (multiplicity > 1) ans.append("").append(multiplicity);
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        String formula1 = "H2O";
        String formula2 = "Mg(OH)2";
        String formula3 = "K4(ON(SO3)2)2";
        RecursionCase1 recursionCase1 = new RecursionCase1();
        // 递归解法
        System.out.println("递归解法:");
        System.out.println("示例1:" + recursionCase1.recursion(formula1));
        System.out.println("示例2:" + recursionCase1.recursion(formula2));
        System.out.println("示例3:" + recursionCase1.recursion(formula3));
        // 栈解法
        System.out.println("栈解法:");
        System.out.println("示例1:" + recursionCase1.stack(formula1));
        System.out.println("示例2:" + recursionCase1.stack(formula2));
        System.out.println("示例3:" + recursionCase1.stack(formula3));
    }

}
