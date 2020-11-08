package com.wrongme.tree;

import com.wrongme.basic.TreeNode;
import com.wrongme.utils.BinaryTreeUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BinaryTreeLevelOrderTest {
    private TreeNode root = null;

    @Before
    public void init() {
        root = BinaryTreeUtils.commonBinaryTree();
    }

    @Test
    public void levelOrder() {
        BinaryTreeLevelOrder binaryTreeLevelOrder = new BinaryTreeLevelOrder();
        List list = binaryTreeLevelOrder.levelOrder(root);
        System.out.println(list);
    }
}