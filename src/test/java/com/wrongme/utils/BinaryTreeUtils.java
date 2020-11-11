package com.wrongme.utils;

import com.wrongme.basic.TreeNode;

public class BinaryTreeUtils {

    /**
     * 满二叉树
     * 1
     * \     \
     * 2        3
     * \    \   \   \
     * 4    5   6    7
     *
     * @return
     */
    public static TreeNode fullBinaryTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        return root;
    }

    /**
     * 普通树
     *         1
     *     \      \
     *     2       3
     *   \    \   \
     *   4    5   6
     *       \
     *       7
     *
     * @return
     */
    public static TreeNode commonBinaryTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node7;
        node3.left = node6;
        return root;
    }

    /**
     * 只有左子树
     *    1
     *   \
     *   2
     *  \
     * 3
     *
     * @return
     */
    public static TreeNode leftBinaryTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        node2.left = node3;
        return root;
    }


    /**
     * 只有右子树
     *     1
     *    \
     *    2
     *  \
     *  3
     *
     * @return
     */
    public static TreeNode rightBinaryTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node2;
        node2.right = node3;
        return root;
    }

    /**
     * BFS 二叉搜索树
     *
     * @return
     */
    public static TreeNode binarySerachTree() {
        TreeNode root = new TreeNode(50);
        TreeNode node2 = new TreeNode(25);
        TreeNode node3 = new TreeNode(75);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(40);
        TreeNode node6 = new TreeNode(65);
        TreeNode node7 = new TreeNode(80);
        TreeNode node8 = new TreeNode(30);
        TreeNode node9 = new TreeNode(90);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node7.right = node9;
        return root;
    }

}
