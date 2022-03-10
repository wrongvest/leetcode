package com.wrongme.daily.w20220308;

import java.util.ArrayList;
import java.util.List;

public class Thursday {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root==null){
            return ans;
        }
        ans.add(root.val);
        if (root.children!=null){
            for (Node child : root.children) {
                preorder(child);
            }
        }
        return ans;
    }

}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}