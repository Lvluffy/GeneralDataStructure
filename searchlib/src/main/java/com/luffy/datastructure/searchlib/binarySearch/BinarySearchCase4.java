package com.luffy.datastructure.searchlib.binarySearch;

/**
 * Created by lvlufei on 2019/11/12
 *
 * @name 二分搜索
 * @desc 案例分析四：不定长的边界
 * <p>
 * 题目：有一段不知道具体长度的日志文件，里面记录了每次登录的时间戳，已知日志是按顺序从头到尾记录的，没有记录日志的地方为空，要求当前日志的长度。
 * <p>
 * 解题思路：
 * 可以把这个问题看成是不知道长度的数组，数组从头开始记录都是时间戳，到了某个位置就成为了空：{2019-01-14, 2019-01-17, … , 2019-08-04, …. , null, null, null ...}。
 */
public class BinarySearchCase4 {

    /**
     * 二分搜索-递归解法
     *
     * @param logs  数组数据
     * @param left  左边索引（起点）
     * @param right 右边索引（终点）
     * @return 返回目标值所在数组索引
     */
    public int binarySearchRecursion(String[] logs, int left, int right) {
        //为了避免无限循环，先判断，如果起点位置大于终点位置，表明超出了搜索区间，无法找到目标数，返回-1。
        if (left > right) {
            return -1;
        }
        //取中位数。
        int middle = left + (right - left) / 2;
        //判断中位数是否为要找的数，如果是，就返回中位数下标。
        if (logs[middle] == null && logs[middle - 1] != null) {
            return middle;
        }
        //如果目标值在左边，就从左半边递归地进行二分搜索；否则从右半边递归地进行二分搜索。
        if (logs[middle] == null) {
            return binarySearchRecursion(logs, left, middle - 1);
        } else {
            return binarySearchRecursion(logs, middle + 1, right);
        }
    }

    /**
     * 二分搜索-非递归解法
     *
     * @param logs  数组数据
     * @param left  左边索引（起点）
     * @param right 右边索引（终点）
     * @return 返回目标值所在数组索引
     */
    public int binarySearch(String[] logs, int left, int right) {
        //在while循环里，判断搜索的区间范围是否有效
        while (left <= right) {
            //取中位数
            int middle = left + (right - left) / 2;
            //判断中位数是否为要找的数，如果是，就返回中位数下标。
            if (logs[middle] == null && logs[middle - 1] != null) {
                return middle;
            }
            //如果目标值在左边，调整搜索区间的终点为"middle - 1"；否则，调整搜索区间的起点为"middle + 1"。
            if (logs[middle] == null) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        //如果超出了搜索区间，表明无法找到目标数，返回-1。
        return -1;
    }

    public static void main(String[] args) {
        String[] logs = {"2019-01-01", "2019-01-02", "2019-01-03", "2019-01-04", "2019-01-05", null, "2019-01-07"};
        BinarySearchCase4 binarySearchCase4 = new BinarySearchCase4();
        //递归解法
        int resultIndexRecursion = binarySearchCase4.binarySearchRecursion(logs, 0, logs.length - 1);
        System.out.println("二分搜索-递归解法：" + resultIndexRecursion);
        //非递归解法
        int resultIndex = binarySearchCase4.binarySearch(logs, 0, logs.length - 1);
        System.out.println("二分搜索-非递归解法：" + resultIndex);
    }

}
