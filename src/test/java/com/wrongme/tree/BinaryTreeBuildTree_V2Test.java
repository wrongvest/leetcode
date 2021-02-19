package com.wrongme.tree;

import com.wrongme.basic.TreeNode;
import org.junit.Test;

public class BinaryTreeBuildTree_V2Test {

    @Test
    public void buildTree() {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder  = new int[]{9,15,7,20,3};
        BinaryTreeBuildTree_V2 v2 = new BinaryTreeBuildTree_V2();
        TreeNode root = v2.buildTree(inorder,postorder);
    }
}