package com.luffy.datastructure.leetcodelib.array;

/**
 * Created by lvlufei on 2021-01-13
 *
 * @name 给出一个山脉数组，返回最大值的索引。
 * <p>
 * 山脉数组，需要满足如下条件：
 * <p>
 * 首先，A.length >= 3
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * <p>
 * 例如：
 * 1,2,3,4,5,3,1
 * 0,1,2,4,2,1
 */
public class Array_4 {

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 3, 5, 7, 9, 10, 12, 8, 6, 5};//返回6
        int[] array2 = new int[]{1, 2, 3, 4, 5, 3, 1};//返回4
        int[] array3 = new int[]{0, 1, 2, 4, 2, 1};//返回3
        System.out.println("mountainTop:" + mountainTop(array1));
        System.out.println("mountainTop:" + mountainTop(array2));
        System.out.println("mountainTop:" + mountainTop(array3));
    }

    /**
     * 二分法
     *
     * @param array
     * @return
     */
    public static int mountainTop(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (array[mid] < array[mid + 1]) {
                start = mid + 1;
            } else if (array[mid] < array[mid - 1]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
