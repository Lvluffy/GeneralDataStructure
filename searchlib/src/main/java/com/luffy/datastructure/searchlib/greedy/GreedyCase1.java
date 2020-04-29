package com.luffy.datastructure.searchlib.greedy;

/**
 * Created by lvlufei on 2019/11/13
 *
 * @name 贪婪算法
 * @desc 案例分析：跳跃游戏
 * <p>
 * 题目：给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。判断你是否能够到达最后一个位置。
 * <p>
 * 示例1：
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * <p>
 * 示例二：
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class GreedyCase1 {

    /**
     * 回溯解法
     * <p>
     * 这是一个低效的解决方法。我们模拟从第一个位置跳到最后位置的所有方案。
     * 从第一个位置开始，模拟所有可以跳到的位置，然后从当前位置重复上述操作，当没有办法继续跳的时候，就回溯。
     * <p>
     * 时间复杂度：O(2^n)，最多有2^n种从第一个位置到最后一个位置的跳跃方式，其中n是数组nums的元素个数。
     * 空间复杂度：O(n)，回溯法只需要栈的额外空间。
     *
     * @param nums 数组数据
     * @return
     */
    public boolean backtracking(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    private boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 动态规划解法的辅助空间
     */
    enum Index {
        GOOD, BAD, UNKNOWN
    }

    /**
     * 动态规划解法-自顶向下
     * <p>
     * 利用记忆表优化。
     * <p>
     * 自顶向下的动态规划可以理解成回溯法的一种优化。我们发现当一个坐标已经被确定为好 / 坏之后，结果就不会改变了，这意味着我们可以记录这个结果，每次不用重新计算。
     * <p>
     * 时间复杂度：O(n^2)，数组中的每个元素，假设为i，需要搜索右边相邻的nums[i]个元素查找是否有GOOD的坐标。 nums[i]最多为n，n是nums数组的大小。
     * 空间复杂度：O(2n)=O(n)，第一个n是栈空间的开销，第二个n是记忆表的开销。
     *
     * @param nums 数组数据
     * @return
     */
    public boolean dynamicPlanDown(int[] nums) {
        //开辟记忆表空间，初始化memo的所有元素为UNKNOWN。
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        //标记最后一个显然是GOOD（自己一定可以跳到自己）
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(memo, 0, nums);
    }

    private boolean canJumpFromPosition(Index[] memo, int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(memo, nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }

    /**
     * 动态规划解法-自底向上
     * <p>
     * 移除递归的部分。
     * <p>
     * 自底向上和自顶向下动态规划的区别就是消除了回溯，在实际使用中，自底向下的方法有更好的时间效率，因为我们不再需要栈空间，可以节省很多缓存开销。
     * 更重要的事，这可以让之后更有优化的空间。回溯通常是通过反转动态规划的步骤来实现的。
     * <p>
     * 时间复杂度：O(n^2)，数组中的每个元素，假设为i，需要搜索右边相邻的nums[i]个元素查找是否有GOOD的坐标。nums[i]最多为n，n是nums数组的大小。
     * 空间复杂度：O(n)，记忆表的存储开销。
     *
     * @param nums 数组数据
     * @return
     */
    public boolean dynamicPlanUpward(int[] nums) {
        //开辟记忆表空间
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        //标记最后一位坐标是：好的
        memo[memo.length - 1] = Index.GOOD;
        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }

    /**
     * 贪婪解法
     * <p>
     * 时间复杂度：O(n)，只需要访问 nums 数组一遍，共n个位置，n是nums数组的长度。
     * 空间复杂度：O(1)，不需要额外的空间开销。
     *
     * @param nums 数组数据
     * @return
     */
    public boolean greedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        GreedyCase1 greedyCase1 = new GreedyCase1();
        //回溯解法
        System.out.println("数据1，回溯解法：" + greedyCase1.backtracking(nums1));
        System.out.println("数据2，回溯解法：" + greedyCase1.backtracking(nums2));
        //动态规划解法-自顶向下
        System.out.println("数据1，动态规划解法-自顶向下：" + greedyCase1.dynamicPlanDown(nums1));
        System.out.println("数据2，动态规划解法-自顶向下：" + greedyCase1.dynamicPlanDown(nums2));
        //动态规划解法-自底向上
        System.out.println("数据1，动态规划解法-自底向上：" + greedyCase1.dynamicPlanUpward(nums1));
        System.out.println("数据2，动态规划解法-自底向上：" + greedyCase1.dynamicPlanUpward(nums2));
        //贪婪解法
        System.out.println("数据1，贪婪解法：" + greedyCase1.greedy(nums1));
        System.out.println("数据2，贪婪解法：" + greedyCase1.greedy(nums2));
    }

}
