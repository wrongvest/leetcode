package com.wrongme.tree;

import com.wrongme.basic.TreeNode;
import com.wrongme.utils.BinaryTreeUtils;
import org.junit.Test;

public class BinaryTreeMaxDepthTest {

    @Test
    public void maxDepthBfs() {
        TreeNode root = BinaryTreeUtils.commonBinaryTree();
        BinaryTreeMaxDepth treeMaxDepth = new BinaryTreeMaxDepth();
        System.out.println(treeMaxDepth.maxDepth2(root));
    }

    @Test
    public void maxDepthWithRecursive() {
        TreeNode root = BinaryTreeUtils.commonBinaryTree();
        BinaryTreeMaxDepth treeMaxDepth = new BinaryTreeMaxDepth();
        System.out.println(treeMaxDepth.maxDepth(root));
    }
}