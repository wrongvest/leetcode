package com.wrongme.daily;

import com.wrongme.basic.ListNode;

import java.util.Stack;

public class GetIntersectionNodeSolution {

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        for (ListNode h1 = headA; h1 != null; h1 = headA.next) {
            for (ListNode h2 = headB; h2 != null; h2 = headB.next) {
                if (h1.equals(h2)) {
                    return h1;
                }
            }
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while (headA != null || headB != null) {
            if (headA != null) {
                stackA.push(headA);
                headA = headA.next;
            }
            if (headB != null) {
                stackB.push(headB);
                headB = headB.next;
            }
        }
        ListNode insertNode = null;
        while (!stackA.isEmpty() && !stackB.isEmpty() && stackA.peek().equals(stackB.peek())) {
            ListNode nodeA = stackA.pop();
            ListNode nodeB = stackB.pop();
            insertNode = nodeA;
        }
        return insertNode;
    }

    public static void main(String[] args) {
        GetIntersectionNodeSolution solution = new GetIntersectionNodeSolution();
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = new ListNode(8);
        headB.next.next.next.next = new ListNode(4);
        headB.next.next.next.next.next = new ListNode(5);

        solution.getIntersectionNode(headA, headB);
    }
}
