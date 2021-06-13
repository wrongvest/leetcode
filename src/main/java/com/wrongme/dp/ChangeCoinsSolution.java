package com.wrongme.dp;

/**
 * 518. 零钱兑换 II
 */
public class ChangeCoinsSolution {
    // 定义 dp[i][j] 为考虑前 i 件物品，凑成总和为 j 的方案数量。
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        // base case
        for (int i = 1; i <= n; i++) {
            // 第i枚硬币的价值
            int val= coins[i-1];
            for (int j = 0; j <=amount; j++) {
                dp[i][j] = dp[i-1][j];
                for (int k = 1; k*val <= j; k++) {
                    dp[i][j] += dp[i-1][j-k*val] ;
                }
            }
        }
        return dp[n][amount];

    }
}
