package com.wrongme.daily.other;

import com.wrongme.basic.ListNode;

public class RemoveElementsSolution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy  = new ListNode(-99999);
        dummy .next = head;
        ListNode current = dummy;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveElementsSolution solution = new RemoveElementsSolution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        solution.removeElements(head, 6);
    }
}
