package com.luffy.datastructure.searchlib.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lvlufei on 2019/11/19
 *
 * @name 递归
 * @desc 案例分析：中心对称数
 * <p>
 * 题目：找到所有长度为 n 的中心对称数。
 * <p>
 * 说明：中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 * <p>
 * 示例：
 * 输入:  n = 2
 * 输出: ["11","69","88","96"]
 */
public class RecursionCase2 {

    public static void main(String[] args) {
        System.out.println(recursion(2));
    }

    /**
     * 递归解法
     *
     * @param n
     * @return
     */
    public static List<String> recursion(int n) {
        if (n == 1) {
            return Arrays.asList("0", "1", "8");
        }
        HashMap<Integer, List<String>> map = new HashMap<>();
        // 这个是递归的处理方法
        List<String> stringList = recursionAuxiliary(n, map);
        //通过迭代器去除以0开头的字符串
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().startsWith("0")) {
                iterator.remove();
            }
        }
        return stringList;
    }

    /**
     * 递归辅助
     *
     * @param n
     * @param map
     * @return
     */
    private static List<String> recursionAuxiliary(int n, HashMap map) {
        if (map.containsKey(n)) {
            return (List<String>) map.get(n);
        }
        if (n == 1) {
            List<String> list = new ArrayList<>();
            list.add("0");
            list.add("1");
            list.add("8");
            map.put(1, list);
            return list;
        }
        if (n == 2) {
            List<String> list = new ArrayList<>();
            list.add("00");
            list.add("11");
            list.add("69");
            list.add("88");
            list.add("96");
            map.put(2, list);
            return list;
        }
        List<String> list1 = recursionAuxiliary(2, map);
        List<String> list2 = recursionAuxiliary(n - 2, map);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                result.add(list1.get(i).charAt(0) + list2.get(j) + list1.get(i).charAt(1));
            }
        }
        return result;
    }
}
