package com.luffy.datastructure.leetcodelib.linkedList;

/**
 * Created by lvlufei on 2020-02-19
 *
 * @name 链表反转
 */
public class LeetCode_206 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node1 = reverseIteration(node1);
        while (node1 != null) {
            System.out.print(node1.getVal() + " ");
            node1 = node1.getNext();
        }
    }

    /**
     * 迭代法
     * <p>
     * 遍历，双指针一前一后同时向尾部移动
     *
     * @param head 要反转的链表的头结点
     * @return
     */
    public static ListNode reverseIteration(ListNode head) {
        //当前结点为null，或者当前结点没有后续结点时，递归退出
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode pre = head;            //前一个指针
        ListNode cur = head.getNext();  //当前指针
        ListNode next;                  //下一个指针
        while (cur != null) {
            next = cur.getNext();
            cur.setNext(pre); // 反转指针域的指向
            //指针后移
            pre = cur;
            cur = next;
        }
        //一定记得把初始链表头结点的next置为null，因为反转后它将会是最后一个结点
        head.setNext(null);
        return pre;
    }

    /**
     * 递归法
     * <p>
     * 在翻转当前节点之前，如果该节点有后续节点，先翻转其后续节点
     * 如果该节点没有子节点，就把该节点的next指向其父节点，并把父节点的next置为null
     *
     * @param head
     * @return
     */
    public static ListNode reverseRecursion(ListNode head) {
        //当前结点为null，或者当前结点没有后续结点时，递归退出
        if (head == null || head.getNext() == null) {
            return head;
        }
        //当前结点不为null并且有next时，递归去反转它的后续结点
        ListNode tempNode = reverseRecursion(head.getNext());
        //反转当前结点和它的子结点
        head.getNext().setNext(head);
        head.setNext(null);
        return tempNode;
    }
}
