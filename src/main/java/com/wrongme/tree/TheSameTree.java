package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

/**
 * 100. 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 * @date 2020年11月12日22:13:14
 */
public class TheSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q ==null){
            return true;
        }
        if (p==null || q==null){
            return false;
        }
        if (p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
