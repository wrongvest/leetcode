package com.wrongme.tree;

import com.wrongme.utils.BinaryTreeUtils;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class TreePostorderTraversalTest {

    @Test
    public void postOrderTraversalWithRecursive() {
        TreePostorderTraversal treePostorderTraversal = new TreePostorderTraversal();
        List<Integer> res = treePostorderTraversal.postorderTraversal(BinaryTreeUtils.commonBinaryTree());
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }
}