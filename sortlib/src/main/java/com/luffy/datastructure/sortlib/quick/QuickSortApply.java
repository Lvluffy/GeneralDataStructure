package com.luffy.datastructure.sortlib.quick;

/**
 * Created by lvlufei on 2019/11/8
 *
 * @name 快速排序
 * @desc --
 * <p>
 * 基本原理：快速排序也采用了分治的思想。
 * <p>
 * 实现：把原始的数组筛选成较小和较大的两个子数组，然后递归地排序两个子数组。
 * <p>
 * 过程：快速排序从小到大排序：在数组中随机选一个数（默认数组首个元素），数组中小于等于此数的放在左边，大于此数的放在右边，再对数组两边递归调用快速排序，重复这个过程。
 * <p>
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(logn)
 * <p>
 * 题目：给定一个数组[2,1,7,9,5,8]，要求按照从左到右、从小到大的顺序进行排序。
 */
public class QuickSortApply {

    /**
     * 快速排序
     *
     * @param nums 数组数据
     * @return
     */
    public static int[] sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 排序
     *
     * @param nums  数组数据
     * @param start 开始位置
     * @param end   结束位置
     */
    private static void sort(int[] nums, int start, int end) {
        if (start < end) {
            //寻找基准数据的正确索引
            int index = getIndex(nums, start, end);
            //进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            sort(nums, 0, index - 1);
            sort(nums, index + 1, end);
        }
    }

    /**
     * 获取基准值索引
     *
     * @param nums  数组数据
     * @param start 开始位置
     * @param end   结束位置
     * @return
     */
    private static int getIndex(int[] nums, int start, int end) {
        //基准数据
        int tmp = nums[start];
        while (start < end) {
            //当队尾的元素大于等于基准数据时,向前挪动high指针
            while (start < end && nums[end] >= tmp) {
                end--;
            }
            //如果队尾元素小于tmp了,需要将其赋值给low
            nums[start] = nums[end];
            //当队首元素小于等于tmp时,向前挪动low指针
            while (start < end && nums[start] <= tmp) {
                start++;
            }
            //当队首元素大于tmp时,需要将其赋值给high
            nums[end] = nums[start];

        }
        //跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        //由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[start]
        nums[start] = tmp;
        return start; // 返回tmp的正确位置
    }

    /**
     * 快速排序
     *
     * @param data
     * @param start
     * @param end
     * @return
     */
    public static int[] quickSort(int[] data, int start, int end) {
        if (data == null || data.length == 0) {
            return data;
        }
        if (start > end) {
            return data;
        }
        int tmp = data[start];
        while (start < end) {
            while (start < end && data[end] >= tmp) {
                end--;
            }
            data[start] = data[end];
            while (start < end && data[start] <= tmp) {
                start++;
            }
            data[end] = data[start];
        }
        data[start] = tmp;
        sort(data, 0, start);
        sort(data, start + 1, end);
        return data;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 7, 9, 5, 8};
        sort(nums);
        for (int i : nums) {
            System.out.print(i + "    ");
        }
    }
}
