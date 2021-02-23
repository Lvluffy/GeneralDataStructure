package com.luffy.datastructure.leetcodelib.linkedList;

/**
 * Created by lvlufei on 2021-01-14
 *
 * @name 删除链表的倒数第N个节点
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class LeetCode_19 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(4);
        ListNode next4 = new ListNode(5);
        head.setNext(next1);
        next1.setNext(next2);
        next2.setNext(next3);
        next3.setNext(next4);
        head = removeNthFromEnd_2(head, 2);
        while (head != null) {
            System.out.print(head.getVal() + " ");
            head = head.getNext();
        }
    }


    /**
     * 计算链表长度
     * <p>
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd_1(ListNode head, int n) {
        int length = getLength(head);
        int last = length - n;
        if (last == 0) {
            return head.getNext();
        }
        ListNode temp = head;
        for (int i = 0; i < last - 1; i++) {
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        return head;
    }

    private static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.getNext();
        }
        return length;
    }

    /**
     * 快慢指针
     * <p>
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd_2(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        //快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.getNext();
        }
        if (fast == null) {
            return head.getNext();
        }
        while (fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        slow.setNext(slow.getNext().getNext());
        return head;
    }
}

