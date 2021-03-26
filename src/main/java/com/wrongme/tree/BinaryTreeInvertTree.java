package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

public class BinaryTreeInvertTree {
    public TreeNode invertTree(TreeNode root) {
       return helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        helper(root.left);
        helper(root.right);
        return root;
    }
}
