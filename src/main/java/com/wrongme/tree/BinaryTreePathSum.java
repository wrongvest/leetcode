package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

/**
 * 112. 路径总和
 *
 * @date 2021年3月2日22:33:39
 */
public class BinaryTreePathSum {
    /**
     * 询问是否存在从当前节点 root 到叶子节点的路径，满足其路径和为 sum。
     * <p>
     * 假定从根节点到当前节点的值之和为 val，我们可以将这个大问题转化为一个小问题：
     * 是否存在从当前节点的子节点到叶子的路径，满足其路径和为 sum - val。
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // 叶子节点
        if (root.right==null&& root.left==null){
            return root.val == targetSum;
        }
        return hasPathSum(root.left,targetSum-root.val)|| hasPathSum(root.right,targetSum-root.val);
    }
}
