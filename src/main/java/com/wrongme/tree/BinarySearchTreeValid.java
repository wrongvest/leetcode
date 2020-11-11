package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @date 2020年11月11日21:53:09
 */
public class BinarySearchTreeValid {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        long inorder = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (inorder> node.val){
                return false;
            }
            inorder = node.val;
            root = node.right;
        }
        return true;
    }

}
