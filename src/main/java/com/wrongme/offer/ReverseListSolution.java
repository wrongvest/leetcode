package com.wrongme.offer;

import com.wrongme.basic.ListNode;

import java.util.Stack;

public class ReverseListSolution {

    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode first= head;
        while (!stack.isEmpty()){
            ListNode temp = stack.pop();
            head.next = temp;
            head=temp;
        }
        head.next =null;
        return first;
    }
}
