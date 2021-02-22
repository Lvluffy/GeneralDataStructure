package com.luffy.datastructure.leetcodelib.array;

/**
 * Created by lvlufei on 2020-11-02
 *
 * @name 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class LeetCode_136 {
    public static void main(String[] args) {
        int[] ints = {4, 2, 3, 2, 3};
        System.out.println(singleNumber(ints));
    }

    public static int singleNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }
        return sum;
    }
}
