package com.luffy.datastructure.leetcodelib.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lvlufei on 2020-12-07
 *
 * @name 给定一个集合S，试找出3个数a, b, c，使得a+b+c=0。也即从集合中找出所有的和为0的3个数。
 * <p>
 * 例如：集合S={-1，0， 1， 2， -1， 4}，则满足条件的3个数有2对：(-1, 0, 1)和(-1, 2, -1)。
 * 注意（-1，1，0）与（-1，0，1）算同一个解，所以不用重复考虑。
 */
public class StringCase5 {

    public static Set<List<Integer>> find(List<Integer> data) {
        // 进行排序去重
        Collections.sort(data);
        // 寻找
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < data.size(); i++) {
            for (int j = i + 1; j < data.size(); j++) {
                for (int z = j + 1; z < data.size(); z++) {
                    boolean b = data.get(i) + data.get(j) + data.get(z) == 0;
                    if (b) {
                        List<Integer> list = new ArrayList<>();
                        list.add(data.get(i));
                        list.add(data.get(j));
                        list.add(data.get(z));
                        set.add(list);
                    }
                }
            }
        }
        return set;
    }

    public static void main(String[] args) {
        Integer[] data = {-1, 0, 1, 2, -1, 4};
        Set<List<Integer>> set = find(Arrays.asList(data));
        for (List<Integer> list : set) {
            System.out.println(list);
        }
    }
}
