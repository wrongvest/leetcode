package com.wrongme.daily.w20211112;

import com.wrongme.basic.TreeNode;

public class FindTiltSolution {
    int ans = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        ans = ans + Math.abs(l - r);
        return l + r + root.val;
    }

}
