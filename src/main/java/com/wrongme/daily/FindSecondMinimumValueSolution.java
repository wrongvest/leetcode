package com.wrongme.daily;

import com.wrongme.basic.TreeNode;


public class FindSecondMinimumValueSolution {
    int ans = -1;
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root, root.val);
        return ans;
    }
    private void dfs(TreeNode root, int cur) {
        if (root == null) return ;
        if (root.val != cur) {
            if (ans == -1) ans = root.val;
            else ans = Math.min(ans, root.val);
            return ;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node1.left = node3;
        FindSecondMinimumValueSolution solution = new FindSecondMinimumValueSolution();
        System.out.println(solution.findSecondMinimumValue(node1));
    }

}
