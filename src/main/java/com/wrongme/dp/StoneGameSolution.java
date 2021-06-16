package com.wrongme.dp;

public class StoneGameSolution {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n+2][n+2];
        for (int len = 0; len <=n ; len++) {
            for (int left = 0; left +len -1 <=n; left++) {
                int right = left + len -1;
                int a = piles[left-1] - dp[left+1][right];
                int b = piles[right-1] - dp[left][right-1];
                dp[left][right] = Math.max(a,b);
            }
        }
        return dp[1][n]>0;
    }
}
