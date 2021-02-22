package com.wrongme.tree;

import com.wrongme.utils.BinaryTreeUtils;
import org.junit.Test;

public class BinaryTreeLevelOrder_V2Test {

    @Test
    public void levelOrderBottom() {
        BinaryTreeLevelOrder_V2 v2 = new BinaryTreeLevelOrder_V2();
        v2.levelOrderBottom(BinaryTreeUtils.commonBinaryTree());
    }
}