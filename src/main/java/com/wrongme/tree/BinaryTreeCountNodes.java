package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @date 20210331-2131
 */
public class BinaryTreeCountNodes {

    public int countNodes(TreeNode root) {
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode temp = queue.poll();
                count++;
                if (temp==null){
                    continue;
                }
                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if (temp.right!=null){
                    queue.offer(temp.right);
                }
            }
        }
        return count;
    }
}
