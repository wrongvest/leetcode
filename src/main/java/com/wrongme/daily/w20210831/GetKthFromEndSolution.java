package com.wrongme.daily.w20210831;

import com.wrongme.basic.ListNode;

import java.util.Stack;

public class GetKthFromEndSolution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            head = stack.pop();
            k--;
            if (k <= 0) {
                break;
            }
        }
        return head;
    }
}
