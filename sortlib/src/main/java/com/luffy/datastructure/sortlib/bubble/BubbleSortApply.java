package com.luffy.datastructure.sortlib.bubble;

import com.luffy.datastructure.SwapUtils;

/**
 * Created by lvlufei on 2019/11/7
 *
 * @name 冒泡排序
 * @desc --
 * <p>
 * 基本思想：给定一个数组，我们把数组里的元素通通倒入到水池中，这些元素将通过相互之间的比较，按照大小顺序一个一个地像气泡一样浮出水面。
 * <p>
 * 过程：
 * 冒泡排序从小到大排序：一开始交换的区间为0~N-1，将第1个数和第2个数进行比较，前面大于后面，交换两个数，否则不交换。
 * 再比较第2个数和第三个数，前面大于后面，交换两个数否则不交换。依次进行，最大的数会放在数组最后的位置。然后将范围
 * 变为0~N-2，数组第二大的数会放在数组倒数第二的位置。依次进行整个交换过程，最后范围只剩一个数时数组即为有序。
 * <p>
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * <p>
 * 题目：给定一个数组[2,1,7,9,5,8]，要求按照从左到右、从小到大的顺序进行排序。
 */
public class BubbleSortApply {
    /**
     * 冒泡排序
     *
     * @param nums 数组数据
     * @return
     */
    public static int[] sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        //每一趟确定一个元素，总共numsSize-1趟
        for (int i = 0; i < nums.length - 1; i++) {
            //每次比较两个相邻元素，如果顺序不对，则交换两个元素。
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    SwapUtils.getInstance().swapMedium(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 7, 9, 5, 8};
        sort(nums);
        for (int i : nums) {
            System.out.print(i + "    ");
        }
    }
}
