package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        //List<List<Integer>> levelOrder = new ArrayList<>();
        List<Integer> listView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode treeNode =null;
        while (!queue.isEmpty()){
            int currentLevelSize = queue.size();
            List<Integer> list= new ArrayList<>();
            for (int i = 0; i < currentLevelSize ; i++) {
                treeNode = queue.poll();
                if (treeNode==null){
                    continue;
                }
                list.add(treeNode.val);
                if (treeNode.left!=null){
                    queue.offer(treeNode.left);
                }
                if (treeNode.right!=null){
                    queue.offer(treeNode.right);
                }
            }
            if (treeNode==null){
                continue;
            }
            listView.add(treeNode.val);
//            levelOrder.add(list);
        }
        return listView;
        //return levelOrder.stream().map(list-> list.get(list.size()-1)).collect(Collectors.toList());
    }
}
