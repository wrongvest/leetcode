package com.wrongme.offer;

public class CuttingRope {

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        // n = 1,2,3的返回值不等于result[n]?
        // 由于作为结果返回时，必须要切一段，不能不切。但是作为子问题被引用时，可以作为一整段出现，也就是不切，因此最大值有区别。
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        // j的遍历范围：如果j > i/2，那么result[j]已经由之前的result[i - j]遍历过，导致重复计算，因此j最多遍历到i/2。
        // 同时，由于题目规定必须要切一刀，因此不能使得某一段的长度为0，因此j最少遍历到1。
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i / 2; j++) {
                dp[i] = Math.max(dp[j] * dp[i - j], dp[i]);
            }
        }
        return dp[n];
    }
}
