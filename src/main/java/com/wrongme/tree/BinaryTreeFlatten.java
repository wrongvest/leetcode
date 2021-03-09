package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

import java.util.ArrayList;
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
}
