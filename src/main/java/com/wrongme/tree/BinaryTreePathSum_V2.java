package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 * @date 2021年3月4日21:48:24
 */
public class BinaryTreePathSum_V2 {
    List<List<Integer>> ret = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum = targetSum - root.val;
        if (root.left == null && root.right==null && targetSum == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
        path.pollLast();
    }
}
