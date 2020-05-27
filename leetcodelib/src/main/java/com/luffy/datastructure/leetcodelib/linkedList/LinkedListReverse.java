package com.luffy.datastructure.leetcodelib.linkedList;

/**
 * Created by lvlufei on 2020-02-19
 *
 * @name 链表反转
 * @desc
 */
public class LinkedListReverse {

    /**
     * 链表中的结点
     */
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
     * 迭代法
     * <p>
     * 遍历，双指针一前一后同时向尾部移动
     *
     * @param head 要反转的链表的头结点
     * @return
     */
    public static ListNode reverseIteration(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;            //前一个指针
        ListNode cur = head.getNext();  //后一个指针
        ListNode next;                  //临时对象，指针后移时要用到的
        while (cur != null) {
            next = cur.getNext();
            cur.setNext(pre);
            pre = cur; //指针后移
            cur = next;//指针后移
        }
        //一定记得把初始链表头结点的next置为null，因为反转后它将会是最后一个结点
        head.setNext(null);
        //把头结点设为反转后链表的第一个结点，然后返回就ok
        head = pre;
        return head;
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
        if (head.getNext() == null || head == null) {
            return head;
        }
        //当前结点不为null并且有next时，递归去反转它的后续结点
        ListNode tempNode = reverseRecursion(head.getNext());
        //反转当前结点和它的子结点
        head.getNext().setNext(head);
        head.setNext(null);
        return tempNode;
    }

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
}
