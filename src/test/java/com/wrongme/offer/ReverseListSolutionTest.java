package com.wrongme.offer;

import com.wrongme.basic.ListNode;
import org.junit.Test;

public class ReverseListSolutionTest {

    @Test
    public void reverseList() {
        ListNode head1 = new ListNode(-3);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(-99);
        ReverseListSolution solution = new ReverseListSolution();
        solution.reverseList(head1);
    }
}