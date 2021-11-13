package com.wrongme.weekly.w262;

import com.wrongme.basic.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestSolution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque();
        while (root!=null|| !deque.isEmpty()){
            while (root!=null){
                deque.addLast(root);
                root = root.left;
            }
            root = deque.pollLast();
            if (--k==0){
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }


}
