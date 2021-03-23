package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

import java.util.Stack;

/**
 * @date 20210323
 */
public class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        leftMostInOrder(root);
    }

    private void leftMostInOrder(TreeNode root) {
        while (root!=null){
            this.stack.push(root);
            root = root.left;
        }
    }

    public int next(){
        // 弹出栈顶元素就是最小元素
        TreeNode topSmallestNode = this.stack.pop();
        // 如果最小元素有右节点，把右节点的最小元素入栈
        if (topSmallestNode.right!=null){
            leftMostInOrder(topSmallestNode.right);
        }
        return topSmallestNode.val;
    }

    public boolean hasNext(){
        return this.stack.size()>0;
    }

}
