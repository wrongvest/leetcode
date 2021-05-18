package com.wrongme.offer;

import com.wrongme.basic.ListNode;
import org.junit.Test;

public class DeleteNodeTest {

    @Test
    public void deleteNode() {
        DeleteNode deleteNodeTem = new DeleteNode();
        ListNode head1 = new ListNode(-3);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(-99);
        deleteNodeTem.deleteNode(head1,-3);

//        ListNode head2 = new ListNode(4);
//        head2.next = new ListNode(5);
//        head2.next.next = new ListNode(1);
//        head2.next.next.next = new ListNode(9);
//        deleteNodeTem.deleteNode(head2,1);
    }
}