package com.wrongme.tree;

import com.wrongme.utils.BinaryTreeUtils;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeValidTest {

    @Test
    public void isValidBST() {
        BinarySearchTreeValid binarySearchTreeValid = new BinarySearchTreeValid();
        Assert.assertTrue(binarySearchTreeValid.isValidBST(BinaryTreeUtils.binarySerachTree()));
        Assert.assertFalse(binarySearchTreeValid.isValidBST(BinaryTreeUtils.commonBinaryTree()));

    }

    @Test
    public void isValidBSTWithRecursion() {
        BinarySearchTreeValid binarySearchTreeValid = new BinarySearchTreeValid();
        Assert.assertTrue(binarySearchTreeValid.isValidBST2(BinaryTreeUtils.binarySerachTree()));
        Assert.assertFalse(binarySearchTreeValid.isValidBST2(BinaryTreeUtils.commonBinaryTree()));

    }
}