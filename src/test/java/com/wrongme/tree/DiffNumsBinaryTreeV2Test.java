package com.wrongme.tree;

import com.wrongme.basic.TreeNode;
import org.junit.Test;

import java.util.List;

public class DiffNumsBinaryTreeV2Test {

    @Test
    public void numTrees() {
        DiffNumsBinaryTreeV2 diffNumsBinaryTreeV2 = new DiffNumsBinaryTreeV2();
        List<TreeNode> treeNodes =diffNumsBinaryTreeV2.generateTrees(3);
        BinaryTreeLevelOrder binaryTreeLevelOrder = new BinaryTreeLevelOrder();
        treeNodes.forEach(treeNode -> {
            System.out.println(binaryTreeLevelOrder.levelOrder(treeNode));
        });
    }
}