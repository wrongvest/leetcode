package com.wrongme.offer;

import com.wrongme.basic.ListNode;
import org.junit.Test;

public class MergeTwoListsSolutionTest {

    @Test
    public void mergeTwoLists() {
        MergeTwoListsSolution solution = new MergeTwoListsSolution();
        ListNode l1 = new ListNode(1);
        l1.next= new ListNode(2);
        l1.next.next= new ListNode(4);


        ListNode l2 = new ListNode(1);
        l2.next= new ListNode(3);
        l2.next.next= new ListNode(4);

        solution.mergeTwoLists(l1,l2);

    }
}