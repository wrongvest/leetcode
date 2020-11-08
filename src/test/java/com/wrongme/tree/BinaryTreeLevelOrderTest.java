package com.wrongme.tree;

import com.wrongme.basic.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BinaryTreeLevelOrderTest {
    private TreeNode root = null;

    @Before
    public void init() {
        root = new TreeNode(1);
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
    }

    @Test
    public void levelOrder() {
        BinaryTreeLevelOrder binaryTreeLevelOrder = new BinaryTreeLevelOrder();
        List list = binaryTreeLevelOrder.levelOrder(root);
        System.out.println(list);
    }
}