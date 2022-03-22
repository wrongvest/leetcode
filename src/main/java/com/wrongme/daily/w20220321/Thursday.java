package com.wrongme.daily.w20220321;

import com.wrongme.basic.TreeNode;

public class Thursday {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k);
    }

    private boolean dfs(TreeNode node, int k) {
        if (node == null) {
            return false;
        }
        if (k == 0) {
            return true;
        }
        dfs(node.left, k - node.val);
        return false;
    }
}
