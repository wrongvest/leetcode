package com.wrongme.tree;

import com.wrongme.basic.TreeNode;
import com.wrongme.utils.BinaryTreeUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class TreeInorderTraversalTest {
    private TreeNode root = null;

    @Before
    public void init() {
        root = BinaryTreeUtils.commonBinaryTree();
    }

    @Test
    public void inorderTraversal2() {
        TreeInorderTraversal binaryTree = new TreeInorderTraversal();
        List<Integer> res = binaryTree.inorderTraversal2(root);
        String result = res.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(result);
    }

    @Test
    public void inorderTraversal1() {
        TreeInorderTraversal binaryTree = new TreeInorderTraversal();
        List<Integer> res = binaryTree.inorderTraversal1(root);
        String result = res.stream().map(String::valueOf).collect(Collectors.joining(","));
        Assert.assertEquals("4,2,7,5,1,6,3", result);
    }
}