package com.wrongme.offer;

/**
 * 322. 零钱兑换
 *
 * @date 2021年4月7日21:46:53
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // 数组大小为 amount + 1，初始值也为 amount + 1
        int[] dp = new int[amount + 1];
        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

}
