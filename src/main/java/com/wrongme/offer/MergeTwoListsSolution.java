package com.wrongme.offer;

import com.wrongme.basic.ListNode;

public class MergeTwoListsSolution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
//        ListNode next = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                current.next = l2;
                current = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                current = l1;
                l1 = l1.next;
            }
        }
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }
        return head.next;
    }
}
