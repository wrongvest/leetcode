package com.wrongme.tree;

import com.wrongme.utils.BinaryTreeUtils;
import org.junit.Test;

import java.util.List;

public class BinaryTreeZLevelOrderTest {

    @Test
    public void zigzagLevelOrder() {
        BinaryTreeZLevelOrder binaryTreeZLevelOrder = new BinaryTreeZLevelOrder();
        List<List<Integer>> lists = binaryTreeZLevelOrder.zigzagLevelOrder(BinaryTreeUtils.commonBinaryTree());
        lists.stream().forEach(System.out::println);
    }
}