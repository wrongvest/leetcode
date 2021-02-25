package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

/**
 * 111. 二叉树的最小深度
 *
 * @date 2021年2月25日21:23:10
 */
public class BinaryTreeMinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            // 左右子树都为空 则一定是叶子节点
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left!=null){
            minDepth = Math.min(minDepth(root.left),minDepth);
        }
        if (root.right!=null){
            minDepth = Math.min(minDepth(root.right),minDepth);
        }
        return minDepth+1;
    }

}
