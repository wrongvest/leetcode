package com.wrongme.tree;

import com.wrongme.basic.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * @author WRong
 * @date 2021年2月23日21:39:58
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0,nums.length-1,nums);
    }

    private TreeNode helper(int start, int end, int[] nums) {
        if (start>end){
            return null;
        }
        // 选择中间位置左边为根节点
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        // 左子树
        root.left = helper(start,mid-1,nums);
        root.right = helper(mid+1,end,nums);
        return root;
    }
}
