package com.wrongme.tree;

/**
 * 96. 不同的二叉搜索树
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * @author WRong
 * @date 2020年11月9日22:29:02
 */
public class DiffNumsBinaryTree {

//    // 动态规划
//    public int numTrees(int n) {
//
//    }

    public int numTrees2(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
