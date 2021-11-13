package com.wrongme.daily.w20211112;

public class GetMoneyAmountSolution {
    static int[][] cache = new int[210][210];
    public int getMoneyAmount(int n) {
        return dfs(1, n);
    }

    private int dfs(int l, int r) {
        if (l >= r) {
            return 0;
        }
        if (cache[l][r] != 0) return cache[l][r];
        int ans = 0x3f3f3f3f;
        for (int x = l; x <= r; x++) {
            // 当选择的数位x时，至少需要cur才能猜中数字
            int cur = Math.max(dfs(l, x - 1), dfs(x + 1, r)) + x;
            ans = Math.min(ans,cur);
        }
        cache[l][r] = ans;
        return ans;
    }

    public static void main(String[] args) {
        GetMoneyAmountSolution solution = new GetMoneyAmountSolution();
        System.out.println(solution.getMoneyAmount(2));
    }
}
