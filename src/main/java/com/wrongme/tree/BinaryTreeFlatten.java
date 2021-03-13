package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 *
 * @date 2021年3月9日22:26:42
 */
public class BinaryTreeFlatten {
    List<TreeNode> nodeList = new ArrayList<>();

    public void flatten(TreeNode root) {
        preOrderTraversal(root);
        for (int i = 1; i < nodeList.size(); i++) {
            TreeNode pre = nodeList.get(i - 1);
            pre.left = null;
            pre.right = nodeList.get(i);
        }
    }

    private void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        nodeList.add(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }


    // 方法二
    public void flatten2(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

}
