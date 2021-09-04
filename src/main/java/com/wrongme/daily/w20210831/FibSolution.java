package com.wrongme.daily.w20210831;

public class FibSolution {
    int mod = (int)1e9+7;
    public int fib(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
            dp[i] %= mod;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FibSolution solution = new FibSolution();
        System.out.println(solution.fib(5));
    }
}
