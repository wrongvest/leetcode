package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @date 2020年11月17日21:48:37
 */
public class BinaryTreeBuildTree {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int size = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < size ; i++) {
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,size-1,0,size-1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder,
                                int preorder_left, int preorder_right,
                                int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历的第一个节点就是根节点（或者子树的根节点）
        int preorderRoot = preorder_left;
        // 在中序遍历中根节点根节点的 index
        int inorderRoot = indexMap.get(preorder[preorderRoot]);
        // 构造根节点
        TreeNode root= new TreeNode(preorder[preorderRoot]);
        // 得到左子树中的节点数目
        int sizeLeftSubtree = inorderRoot -inorder_left;
        // 递归构造左子树
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素
        // 就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder,inorder,
                preorder_left+1,preorder_left+sizeLeftSubtree,
                inorder_left, inorderRoot - 1);
        root.right = myBuildTree(preorder,inorder,
                preorder_left+sizeLeftSubtree+1,preorder_right,
                inorderRoot+1,inorder_right);
        return root;
    }

    /**
     * 迭代
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }


}
