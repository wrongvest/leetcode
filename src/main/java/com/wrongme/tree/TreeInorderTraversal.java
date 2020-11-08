package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @date 2020年11月8日17:48:15
 * @author WRong
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
class TreeInorderTraversal {
    //    public List<Integer> inorderTraversal2(TreeNode root) {
//
//    }
    // 递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return null;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}