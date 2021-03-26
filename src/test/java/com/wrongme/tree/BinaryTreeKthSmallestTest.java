package com.wrongme.tree;

import com.wrongme.basic.TreeNode;
import com.wrongme.utils.BinaryTreeUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeKthSmallestTest {

    @Test
    public void kthSmallest() {
        BinaryTreeKthSmallest kthSmallest = new BinaryTreeKthSmallest();
        TreeNode root = BinaryTreeUtils.bfs();
        assertEquals(2,kthSmallest.kthSmallest(root,1));
    }
}