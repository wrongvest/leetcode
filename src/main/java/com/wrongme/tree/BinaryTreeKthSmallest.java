package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * @date 2021年3月26日21:38:23
 */
public class BinaryTreeKthSmallest {
    private  static  List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        helper(root);
        if (list.size() <= k) {
            return 0;
        }
        return list.get(k-1);
    }

    private void  helper(TreeNode root) {
        if (root==null){
            return ;
        }
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}
