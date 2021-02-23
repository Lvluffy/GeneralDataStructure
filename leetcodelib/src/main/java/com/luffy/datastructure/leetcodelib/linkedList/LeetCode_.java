package com.luffy.datastructure.leetcodelib.linkedList;

/**
 * Created by lvlufei on 2021-02-23
 *
 * @name 链表中位
 * <p>
 * 题目：寻找链表中位数
 * <p>
 * 示例1：
 * 给定一个链表: 1->2->3->4->5, 返回3.
 * <p>
 * 示例2：
 * 给定一个链表: 1->2->3->4->5->6, 返回3.
 */
public class LeetCode_ {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(4);
        ListNode next4 = new ListNode(5);
        ListNode next5 = new ListNode(6);
        head.setNext(next1);
        next1.setNext(next2);
        next2.setNext(next3);
        next3.setNext(next4);
        next4.setNext(next5);
        System.out.println(getMiddleNode(head).getVal());
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public static ListNode getMiddleNode(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.getNext();
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

}

class ListNode {

    private int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}
