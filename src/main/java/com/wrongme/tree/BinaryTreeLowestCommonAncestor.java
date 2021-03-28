package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * @date 2021年3月28日13:43:25
 */
public class BinaryTreeLowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        for (;;){
            if (p.val<ancestor.val && q.val<ancestor.val){
                ancestor = ancestor.left;
            }else if (p.val> ancestor.val && q.val>ancestor.val){
                ancestor = ancestor.right;
            }else {
                break;
            }
        }
        return ancestor;
    }
}
