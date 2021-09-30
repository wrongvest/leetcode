package com.wrongme.daily.w20210921;

import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next, Node child) {
        this.val = val;
        this.next = next;
        this.child = child;
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}

public class FlattenSolution {

    public Node flatten(Node head) {
        Deque<Node> deque = new ArrayDeque<>();
        Node node = null, temp = head;
        while (head != null || !deque.isEmpty()) {
            if (head.child != null && node != head) {
                deque.push(head);
                head = head.child;
                continue;
            }
            if (head.next == null) {
                node = deque.pop();
                head.next = node;
            }
            head = head.next;

        }
        return temp;
    }

    public static void main(String[] args) {
        FlattenSolution solution = new FlattenSolution();
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        head.next = node1;
        node1.next = node2;
        node1.child = node3;
        node3.next = node4;
        solution.flatten(head);
    }
}
