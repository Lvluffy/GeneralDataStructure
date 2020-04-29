package com.luffy.datastructure.complexlib.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by lvlufei on 2019/11/16
 *
 * @name 图
 * @desc 案例分析：火星词典
 * <p>
 * 题目：现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。假设，您并不知道其中字母之间的先后顺序。
 * 但是，会收到词典中获得一个不为空的单词列表。因为是从词典中获得的，所以该单词列表内的单词已经按这门新语言的字母顺序进行了排序。
 * 您需要根据这个输入的列表，还原出此语言中已知的字母顺序。
 * <p>
 * 示例1：
 * 输入:
 * ["wrt","wrf", "er","ett","rftt"]
 * 输出: "wertf"
 * <p>
 * 示例2：
 * 输入:
 * ["z","x"]
 * 输出: "zx"
 * <p>
 * 示例3：
 * 输入:
 * ["z","x","z"]
 * 输出: ""
 * 解释: 此顺序是非法的，因此返回 ""。
 * <p>
 * 注意：
 * 1，你可以默认输入的全部都是小写字母
 * 2，假如，a的字母排列顺序优先于 b，那么在给定的词典当中 a 定先出现在 b 前面
 * 3，若给定的顺序是不合法的，则返回空字符串即可
 * 4，若存在多种可能的合法字母顺序，请返回其中任意一种顺序即可
 * <p>
 * 思路：
 * 将词典中字符串的字符两两对比，只有第一个不同的字符才是正确的排序，如ert和wrf，只能推断出e的优先级高于w，剩余字符的优先级不能推断。
 * 将字符串的优先级构建为图，然后进行拓扑排序。如果图中无环，则将拓扑排序输出，否则顺序是非法的。
 * 注意对于输入"za","zb","ca","cb"，字符关系为a->b、z->c，输出可以为azbc、zacb，只要输出一种即可。
 */
public class GraphCase1 {

    /**
     * 图解法
     *
     * @param words 数组数据
     * @return
     */
    public String graph(String[] words) {
        // 1.构建图
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
                // 如果字符相同，比较下一个
                if (words[i].charAt(j) == words[i + 1].charAt(j)) continue;
                // 保存第一个不同的字符顺序
                Set<Character> set = map.getOrDefault(words[i].charAt(j), new HashSet<Character>());
                set.add(words[i + 1].charAt(j));
                map.put(words[i].charAt(j), set);
                break;
            }
        }
        // 2.拓扑排序
        // 创建保存入度的数组
        int[] degrees = new int[26];
        Arrays.fill(degrees, -1);
        // 注意，不是26字母都在words中出现，所以出度分为两种情况：没有出现的字母出度为-1，出现了的字母的出度为非负数
        for (String str : words) {
            // 将出现过的字符的出度设定为0
            for (char c : str.toCharArray())
                degrees[c - 'a'] = 0;
        }
        for (char key : map.keySet()) {
            for (char val : map.get(key)) {
                degrees[val - 'a']++;
            }
        }
        // 创建StringBuilder保存拓扑排序
        StringBuilder stringBuilder = new StringBuilder();
        // 创建一个Queue保存入度为0的节点
        Queue<Character> queue = new LinkedList<>();
        int count = 0;//计算图中节点数
        for (int i = 0; i < 26; i++) {
            if (degrees[i] != -1) count++;
            if (degrees[i] == 0) {
                queue.add((char) ('a' + i));
            }
        }
        while (!queue.isEmpty()) {
            Character cur = queue.poll();
            stringBuilder.append(cur);
            // 将邻接点出度-1
            if (map.containsKey(cur)) {
                Set<Character> set = map.get(cur);
                for (Character c : set) {
                    degrees[c - 'a']--;
                    if (degrees[c - 'a'] == 0) queue.add(c);
                }
            }
        }
        // 判断是否有环
        if (stringBuilder.length() != count) {
            return "";
        } else {
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        String[] words1 = {"wrt", "wrf", "er", "ett", "rftt"};
        String[] words2 = {"z", "x"};
        String[] words3 = {"z", "x", "z"};
        GraphCase1 graphCase1 = new GraphCase1();
        System.out.println("示例1：" + graphCase1.graph(words1));
        System.out.println("示例2：" + graphCase1.graph(words2));
        System.out.println("示例3：" + graphCase1.graph(words3));
    }
}
