package com.wrongme.daily.w20220315;

import com.wrongme.basic.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Saturday {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        Set<TreeNode> visit = new HashSet<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            if (visit.contains(node)) {
                sb.append(")");
                continue;
            }
            deque.addLast(node);
            sb.append("(");
            sb.append(node.val);
            if (node.right != null) {
                deque.addLast(node.right);
            }
            if (node.left != null) {
                deque.addLast(node.left);
            } else if (node.right != null) {
                sb.append("()");
            }
            visit.add(node);
        }

        return sb.substring(1,sb.length()-1);
    }
}
