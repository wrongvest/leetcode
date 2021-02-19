package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class BinaryTreeBuildTree_V2 {

    int post_idx;
    private int[] postorder;
    private int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    /**
     * 后序遍历的数组最后一个元素代表的即为根节点
     * <p>
     * 中序遍历的数组分成左右两部分，左边部分即左子树，右边部分为右子树
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);
        // 下标减一
        post_idx = post_idx - 1;
        // 构造右子树
        root.right = helper(index+1,in_right);

        // 构造左子树
        root.left = helper(in_left,index-1);
        return root;
    }
}
