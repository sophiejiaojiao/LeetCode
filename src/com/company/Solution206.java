package com.company;

/*
2022-11-20:：LeetCode207单链表反转
 */

public class Solution206 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //Utils.printLinkedList(node1);
        node1.next = null;
        node2.next = node1;
        node3.next = node2;
        node4.next = node3;
        node5.next = node4;
        //Utils.printLinkedList(node5);
        Utils.printLinkedList(new Solution206().reverseList(node1));
    }

    public ListNode reverseList(ListNode head) {
        /*
        解题思路：
        1. 因为每次要找两个节点反转，所以定义了两个节点；preNode初始值为null，是因为反转之后它是尾节点，尾节点是null
        2. while循环中让currentNode指向preNode，即可把节点反转
        3. 反转完，把当前两节点往后挪一位，继续反转
         */
        ListNode preNode = null; // 定义假数据
        ListNode currentNode = head;

        while (currentNode != null) {
            // 先保存下一个节点，再反转
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;

            //挪箭头
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }
}