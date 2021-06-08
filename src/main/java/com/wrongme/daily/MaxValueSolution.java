package com.wrongme.daily;

/**
 * 有 N 件物品和一个容量是 V 的背包。每件物品有且只有一件。
 * <p>
 * 第 i 件物品的体积是 v[i]，价值是 w[i]。
 * <p>
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * <p>
 * 示例 1：
 * <p>
 * 输入: N = 3, V = 4, v = [4,2,3], w = [4,2,3]
 * 输出: 4
 * 解释: 只选第一件物品，可使价值最大。
 * 示例 2：
 * <p>
 * 输入: N = 3, V = 5, v = [4,2,3], w = [4,2,3]
 * 输出: 5
 * 解释: 不选第一件物品，选择第二件和第三件物品，可使价值最大。
 */
public class MaxValueSolution {
    /**
     * @param N 物品个数
     * @param C 容量 container
     * @param v 每个商品的体积
     * @param w 每个商品的价值
     * @return
     */
    // dp[N][C] = max(dp[i-1][C],dp[i-1][C-v[i]]+w[i])
    public int maxValue(int N, int C, int[] v, int[] w) {
        int[][] dp = new int[N][C + 1];
        // 处理第一件商品，即只选第一件的情况
        for (int i = 0; i <= C; i++) {
            // 背包容量为i 时 ，只能选前1件商品（即要么选第一件，要么不选第一件）
            // 背包容量大于第一件商品的体积时，选第一件，背包容量不足时，不能选第一件商品
            dp[0][i] = i < v[0] ? 0 : w[0];
        }
        // 选2件以上
        for (int i = 1; i < N; i++) {
            // 容量从0开始递增
            // j背包此刻的容量
            for (int j = 0; j <= C; j++) {
                // 1.不选第i件商品
                int t1 = dp[i - 1][j];

                // 2.选第i件
                int t2 = 0;
                // 背包容量大于第i件商品的体积
                if (j > v[i]) {
                    t2 = dp[i - 1][j - w[i - 1]] + w[i];
                }
                dp[i][j] = Math.max(t1, t2);
            }
        }
        return dp[N - 1][C];
    }
}
