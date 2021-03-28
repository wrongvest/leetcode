package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @author wrong
 * @date 2020年11月8日23:20:45
 */
public class TreePostorderTraversal {

//    public List<Integer> postorderTraversal3(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        while (!stack.isEmpty() || root != null) {
//            while (root!=null){
//                res.add(root.val);
//                stack.push(root.left);
//                root = root.right;
//            }
//            root = stack.pop();
//        }
//
//        Collections.reverse(res);
//        return res;
//    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 1.第一次满足root.right == null 时，说明此时已经是叶子节点。
            // 2.判断root.right == prev 的作用是，防止出现死循环，
            // 因为当root.right==prev 说明 root的右节点已经遍历过了
            // 举例：如下图所示的树 当此时 res = [4,7,5] 时 prev = 节点5
            //    从栈中pop 节点2， 节点2的right节点为节点5，不为空，
            //    但是节点5已经遍历过了，肯定是不能继续遍历了
            /**
             * 普通树
             *         1
             *     \      \
             *     2       3
             *   \    \   \
             *   4    5   6
             *       \
             *       7
             */
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    private void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }

}
