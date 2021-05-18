package com.wrongme.offer;

import com.wrongme.basic.ListNode;

public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode first = head;
        ListNode pre = head;
        if (head.val==val){
            return head.next;
        }
        while (head != null) {
           if (head.val == val){
               pre.next = head.next;
               break;
           }
           pre =head;
           head = head.next;

        }
        return first;
    }
}
