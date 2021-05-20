package com.wrongme.offer;

import com.wrongme.basic.ListNode;

import java.util.Stack;

public class GetKthFromEndSolution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head = head.next;
        }

        while (!stack.isEmpty()&& k>=1){
            ListNode node = stack.pop();
            if (k==1){
                return node;
            }
            k--;
        }
        return null;
    }
}
