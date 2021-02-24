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

    /**
     * 哈希表
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
            head = head.getNext();
        }
        return false;
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public static boolean hasCycle_pointer(ListNode head) {
        if (head == null || head.getNext() == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.getNext();
        while (slow != fast) {
            if (fast == null || fast.getNext() == null) {
                return false;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return true;
    }
}
