package com.wrongme.tree;

import com.wrongme.basic.TreeNode;
import com.wrongme.utils.BinaryTreeUtils;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeSymmetricTest {

    @Test
    public void isSymmetric() {
        BinaryTreeSymmetric binaryTreeSymmetric =new BinaryTreeSymmetric();
        TreeNode root = BinaryTreeUtils.fullBinaryTree();
        Assert.assertFalse(binaryTreeSymmetric.isSymmetric(root));
    }
}