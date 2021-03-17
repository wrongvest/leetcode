package com.wrongme.tree;

import com.wrongme.utils.BinaryTreeUtils;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class TreePreorderTraversalTest {

    @Test
    public void preOrderTraversalWithStack() {
        TreePreorderTraversal treePreorderTraversal = new TreePreorderTraversal();
        List<Integer> res = treePreorderTraversal.preorderTraversal(BinaryTreeUtils.commonBinaryTree());
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }

    @Test
    public void preOrderTraversalWithStack2() {
        TreePreorderTraversal treePreorderTraversal = new TreePreorderTraversal();
        List<Integer> res = treePreorderTraversal.preorderTraversal2(BinaryTreeUtils.commonBinaryTree());
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }
}