package com.wrongme.tree;

import com.wrongme.basic.TreeNode;
import com.wrongme.utils.BinaryTreeUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeRightSideViewTest {
    TreeNode root = null;
    @Before
    public void init() {
        root = BinaryTreeUtils.commonBinaryTree();
    }

    @Test
    public void levelOrder() {
        BinaryTreeRightSideView rightSideView = new BinaryTreeRightSideView();
        List<Integer> list = rightSideView.rightSideView(root);
        System.out.println(list);
    }
}