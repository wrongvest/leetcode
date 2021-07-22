package com.wrongme.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 */
public class CopyRandomListSolution {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(-1);
        Node h = head;
        while (h != null) {
            Node node = new Node(h.val);
            // 抓住下一个节点
            Node next = h.next;
            // 新节点插入 两个节点之间
            h.next = node;
            // 把尾巴接到新节点后面
            node.next = next;
            // 处理下一个节点（跳过了新new的节点）
            h = next;
        }
        // 重新回到起点
        h = head;
        while (h != null) {
            if (h.random != null) {
                h.next.random = h.random.next;
            }
            // 跳 2格
            h = h.next.next;
        }

        Node ans = head.next;
        while (head != null) {
            Node temp = head.next;
            if (temp != null) {
                head.next = head.next.next;
            }
            head = temp;
        }

        return ans;
    }

    public Node copyRandomList2(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node h = head;
        Node tail = dummy;
        while (h != null) {
            Node node = new Node(h.val);
            map.put(h, node);
            tail.next = node;
            tail = tail.next;
            h = h.next;
        }
        tail = dummy.next;
        while (head != null) {
            Node random = head.random;
            if (random != null) {
                tail.random = map.get(random);
            }
            head = head.next;
            tail = tail.next;
        }
        return dummy.next;
    }


}
