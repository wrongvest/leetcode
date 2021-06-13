package com.wrongme.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumSquaresSolution {
    int INF = 0x3f3f3f3f;

    public int numSquares(int n) {
        List<Integer> squaresList = new ArrayList<>();
        int t = 1;
        while (t * t <= n) {
            squaresList.add(t * t);
            t++;
        }
        int m = squaresList.size();
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], INF);
        dp[0][0] = 0;
        for (int i = 1; i <= squaresList.size(); i++) {
            int squareVal = squaresList.get(i - 1);
            for (int j = 0; j <= n; j++) {
                // 不选第i个数
                dp[i][j] = dp[i - 1][j];
                // 选k次
                for (int k = 1; k * squareVal <= j; k++) {
                    // 能够选择 k 个 x 的前提是剩余的数字 j - k * x 也能被凑出
                    if (dp[i - 1][j - k * squareVal] != INF) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * squareVal]+k);
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        NumSquaresSolution solution = new NumSquaresSolution();
        System.out.println(solution.numSquares(12));
    }
}
