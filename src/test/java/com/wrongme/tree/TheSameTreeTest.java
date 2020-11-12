package com.wrongme.tree;

import com.wrongme.basic.TreeNode;
import com.wrongme.utils.BinaryTreeUtils;
import org.junit.Assert;
import org.junit.Test;

public class TheSameTreeTest {

    @Test
    public void isSameTree() {
        TheSameTree theSameTree = new TheSameTree();
        TreeNode root = BinaryTreeUtils.commonBinaryTree();
        Assert.assertTrue(theSameTree.isSameTree(root,root));

        TreeNode root2 = BinaryTreeUtils.fullBinaryTree();
        Assert.assertFalse(theSameTree.isSameTree(root,root2));
    }
}