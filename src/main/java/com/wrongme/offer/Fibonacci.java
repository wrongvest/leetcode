package com.wrongme.offer;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 */
public class Fibonacci {

    public int fib1(int n) {
        if (n == 0) return 0;
        int[] memo = new int[n + 1];
        // 进行带备忘录的递归
        return helper(memo, n);
    }

    private int helper(int[] memo, int n) {
        // base case
        if (n == 1 || n == 2) {
            return 1;
        }
        // 已经计算过
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    public int fib2(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }


    /**
     * 递归
     *
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib3(n - 1) + fib3(n - 2);
    }
}
