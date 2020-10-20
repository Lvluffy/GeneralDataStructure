package com.luffy.datastructure;

/**
 * Created by lvlufei on 2020-10-20
 *
 * @name 交换-辅助工具
 */
public class SwapUtils {

    private SwapUtils() {
    }

    public static SwapUtils getInstance() {
        return new SwapUtilsHolder().instance;
    }

    private static class SwapUtilsHolder {
        private final SwapUtils instance = new SwapUtils();
    }

    /**
     * 交换-简单
     *
     * @param nums 数组数据
     * @param a    下标a
     * @param b    下标b
     */
    public void swapSimple(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * 交换-中等
     *
     * @param nums 数组数据
     * @param a    下标a
     * @param b    下标b
     */
    public void swapMedium(int[] nums, int a, int b) {
        nums[a] = nums[a] + nums[b];
        nums[b] = nums[a] - nums[b];
        nums[a] = nums[a] - nums[b];
    }

    /**
     * 交换-高级
     *
     * @param nums 数组数据
     * @param a    下标a
     * @param b    下标b
     */
    public void swapDifficult(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}
