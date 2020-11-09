package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author wrong
 * @date 2020年11月8日20:56:03
 */
public class BinaryTreeMaxDepth {
    // 广度优先搜索
    // 父节点入队，父节点出队列，先左子节点入队，后右子节点入队。递归遍历全部节点即可
    public int maxDepth2(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 当前层的结点个数
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                // 将当前结点的左右子树入队
                if (node.left != null) {
                    // 左子树入队
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    // 右子树入队
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;

    }
}
