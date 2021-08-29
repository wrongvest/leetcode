package com.wrongme.daily.w20210824;

public class FndCheapestPriceSolution {
    int INF = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] memo = new int[n][k + 2];
        int ans = dfs(flights, src, dst, k + 1, memo);
        return ans >= INF ? -1 : ans;
    }

    // 表示从 i 到 dst 的走 k 步的最小价格
    private int dfs(int[][] flights, int i, int dst, int k, int[][] memo) {
        if (k < 0) {
            return INF;
        }

        if (i == dst) {
            return 0;
        }

        if (memo[i][k] != 0) {
            return memo[i][k];
        }

        int min = INF;
        for (int[] flight : flights) {
            // 遍历 i 的下一个节点
            if (flight[0] == i) {
                min = Math.min(min, dfs(flights, flight[1], dst, k - 1, memo) + flight[2]);

            }
        }

        memo[i][k] = min;
        return min;
    }
}
