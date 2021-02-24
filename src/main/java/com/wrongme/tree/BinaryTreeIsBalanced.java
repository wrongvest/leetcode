package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

/***
 * 110. 平衡二叉树
 * @date 2021年2月24日21:03:09
 */
public class BinaryTreeIsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
