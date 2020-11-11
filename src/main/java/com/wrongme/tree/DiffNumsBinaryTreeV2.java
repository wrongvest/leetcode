package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * @author WRong
 * @date 2020年11月9日22:29:02
 */
public class DiffNumsBinaryTreeV2 {

    // 递归
    public List<TreeNode> generateTrees(int n) {
        if (n==0){
        return new LinkedList<>();
    }
        return generateTrees(1, n);
}

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end ; i++) {
            // 左子树集合
            List<TreeNode> leftTreeList = generateTrees(start,i-1);
            // 右子树集合
            List<TreeNode> rightTreeList = generateTrees(i+1,end);
            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            int finalI = i;
            leftTreeList.forEach(left-> rightTreeList.forEach(right->{
                TreeNode curr = new TreeNode(finalI);
                curr.left = left;
                curr.right =right;
                allTrees.add(curr);
            }));
//            for (TreeNode left :leftTreeList) {
//                for(TreeNode right: rightTreeList){
//                    TreeNode currTree = new TreeNode(i);
//                    currTree.left = left;
//                    currTree.right = right;
//                    allTrees.add(currTree);
//                }
//            }
        }
        return allTrees;
    }

}
