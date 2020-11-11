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
    /**
     * 使用中序遍历
     * 性质： 二叉搜索树使用 中序遍历 得到的值构成的序列一定是升序的
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        long inorder = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (inorder > node.val) {
                return false;
            }
            inorder = node.val;
            root = node.right;
        }
        return true;
    }

    /**
     * 递归
     */
    public boolean isValidBST2(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        if (!helper(root.left,lower,val)){
            return false;
        }
        if (!helper(root.right,val,upper)){
            return false;
        }
        return true;
    }
}
