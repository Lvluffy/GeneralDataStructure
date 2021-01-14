package com.luffy.datastructure.leetcodelib.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lvlufei on 2020-12-16
 *
 * @name 给定一个链表，判断链表中是否有环。
 * <p>
 * 例如：1->2->3->4->5  false
 * 例如：1->2->3->4->5->1 true
 */
public class LeetCode_114 {

    public static class ListNode {

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

    /**
     * 有没有环（哈希表）
     *
     * @param head
     * @return
     */
    public static boolean hasCycle_hash(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 有没有环（快慢指针）
     *
     * @param head
     * @return
     */
    public static boolean hasCycle_pointer(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node1);
        System.out.println(hasCycle_pointer(node1));
    }
}
