package com.company;

public class Utils {
    // 打印链表
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }
    }
}
