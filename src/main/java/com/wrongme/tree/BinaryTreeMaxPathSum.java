package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 *
 * @date 2021年3月15日21:46:10
 */
public class BinaryTreeMaxPathSum {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxSum;
    }

    /**
     * 二叉树 abc 可能的情况
     * a
     * / \
     * b   c
     * <p>
     * 1.b + a + c。
     * 2.b + a + a 的父结点。
     * 3.a + c + a 的父结点。
     * 情况 1，表示如果不联络父结点的情况，或本身是根结点的情况。这种情况是没法递归的，但是结果有可能是全局最大路径和。
     * 情况 2 和 3，递归时计算 a+b 和 a+c，选择一个更优的方案返回。
     */
    private int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftVal = Math.max(maxSum(root.left), 0);
        int rightVal = Math.max(maxSum(root.right), 0);
        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int current = root.val + leftVal + rightVal;
        // 和 当前情况的
        maxSum = Math.max(maxSum, current);
        return root.val + Math.max(leftVal,rightVal);
    }
}
