package com.wrongme.daily.w20211112;

import java.util.List;

public class MaxDepthSolution {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        List<Node> children = root.children;
        if (children==null){
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < children.size(); i++) {
            ans = Math.max(maxDepth(children.get(i)), ans);
        }
        return ans+1;
    }


            }

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};