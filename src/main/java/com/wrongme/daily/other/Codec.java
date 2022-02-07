package com.wrongme.daily.other;

import com.wrongme.basic.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Codec {
    int INF = -2000;
    TreeNode emptyNode = new TreeNode(INF);

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            TreeNode tempNode = deque.pollFirst();
            sb.append(tempNode.val).append("_");
            if (!emptyNode.equals(tempNode)) {
                deque.addLast(tempNode.left != null ? tempNode.left : emptyNode);
                deque.addLast(tempNode.right != null ? tempNode.right : emptyNode);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] s = data.split("_");
        int n = s.length;
        TreeNode root = new TreeNode(Integer.valueOf(s[0]));
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        for (int i = 1; i < n - 1; i += 2) {
            TreeNode tempNode = deque.pollFirst();
            int a = Integer.valueOf(s[i]);
            int b = Integer.valueOf(s[i + 1]);
            if (a != INF) {
                tempNode.left = new TreeNode(a);
                deque.addLast(tempNode.left);
            }
            if (b != INF) {
                tempNode.right = new TreeNode(b);
                deque.addLast(tempNode.right);
            }
        }
        return root;
    }
}
