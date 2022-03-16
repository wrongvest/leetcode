package com.wrongme.daily.w20220315;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {
    class Node {
        int cnt;
        // 用于支持 O(1) 插入和删除元素，记作 set
        Set<String> set = new HashSet<>();
        Node left;
        Node right;

        public Node(int cnt) {
            this.cnt = cnt;
        }
    }

    Map<String, Node> map = new HashMap<>();
    Node head;
    Node tail;

    public AllOne() {
        head = new Node(-9999);
        tail = new Node(-9999);
        head.right = tail;
        tail.left = head;
    }

    private void clear(Node node) {
        if (node.set.size() != 0) {
            return;
        }
        node.left.right = node.right;
        node.right.left = node.left;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.set.remove(key);
            Node right = node.right;
            Node next = null;
            if (right != null && right.cnt == node.cnt + 1) {
                next = right;
            } else {
                next = new Node(node.cnt + 1);
                next.left = node;
                next.right = node.right;
                node.right = next;
                if (right != null) {
                    node.right.left = next;
                }
            }
            next.set.add(key);
            map.put(key, next);
            clear(node);
        } else {
            Node node = null;
            // 看看队首元素是cnt多少
            if (head.right.cnt == 1) {
                node = head.right;
            } else {
                node = new Node(1);
                node.right = head.right;
                node.left = head;
                head.right.left = node;
                head.right = node;
            }
            node.set.add(key);
            map.put(key, node);
        }
    }

    public void dec(String key) {
        Node node = map.get(key);
        if (node == null) {
            return;
        }
        node.set.remove(key);
        if (node.cnt == 1) {
            map.remove(key);
        } else {
            Node pre = null;
            if (node.left.cnt == node.cnt - 1) {
                pre = node.left;
            } else {
                pre = new Node(node.cnt - 1);
                pre.left = node.left;
                pre.right = node;
                node.left = pre;
                node.left.right = pre;
            }
            pre.set.add(key);
            map.put(key, pre);
        }
        clear(node);
    }

    public String getMaxKey() {
        Node n = tail.left;
        for (String s : n.set) {
            return s;
        }
        return "";
    }

    public String getMinKey() {
        Node n = head.right;
        for (String s : n.set) {
            return s;
        }
        return "";
    }

    public static void main(String[] args) {
        AllOne obj = new AllOne();
        obj.inc("hello");
        obj.inc("hello111");
        obj.inc("hello111");
        obj.dec("hello");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());
    }
}
