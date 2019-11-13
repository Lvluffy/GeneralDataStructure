package com.luffy.generaldatastructurelib.sort.quick;

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
 * 1，最优情况：被选出来的基准值都是当前子数组的中间数。
 * 这样的分割，能保证对于一个规模大小为n的问题，能被均匀分解成连个规模大小为n/2的子问题（归并排序也采用了相同的划分方法），时间复杂度就是：T(n)=2*T(n/2)+O(n)。
 * 把规模大小为n的问题分解成n/2的两个子问题时，把基准值进行了n-1次比较，复杂度就是O(n)。很显然，在最优情况下，快速排序的复杂度也是O(nlogn)。
 * 2，最坏的情况：基准值选择了子数组里的最大或者最小值。
 * 每次都把子数组分成两个更小的子数组，其中一个的长度为1，另位一个的长度只比原子数组少一。
 * 空间复杂度：O(logn)
 * 和归并排序不同，快速排序在每次递归的过程中，只需要开辟O(1)的存储空间来完成交换操作实现直接对数组的修改，又因为递归次数为logn，所以它的整体空间复杂度完全取决于压堆栈的次数，因此它的空间复杂度是O(logn)。
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
    public static int[] quickSort(int[] nums) throws Exception {
        if (nums == null || nums.length == 0)
            throw new Exception("参数错误");
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

    public static void main(String[] args) {
        int[] nums = {2, 1, 7, 9, 5, 8};
        try {
            quickSort(nums);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i : nums) {
            System.out.print(i + "    ");
        }
    }
}
