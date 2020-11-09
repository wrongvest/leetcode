package com.wrongme.tree;

import com.wrongme.utils.BinaryTreeUtils;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class BreadthFirstSearchTest {

    @Test
    public void bfs() {
        BreadthFirstSearch breadthFirstSearch =new BreadthFirstSearch();
        List<Integer> res =breadthFirstSearch.bfs(BinaryTreeUtils.commonBinaryTree());
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(",")));
        res =breadthFirstSearch.bfs(BinaryTreeUtils.fullBinaryTree());
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(",")));
        res =breadthFirstSearch.bfs(BinaryTreeUtils.leftBinaryTree());
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(",")));

    }
}