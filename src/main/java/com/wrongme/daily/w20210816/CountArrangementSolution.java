package com.wrongme.daily.w20210816;

public class CountArrangementSolution {

    public int countArrangement(int n) {
        int mask = 1 << n;
        int[][] f = new int[n + 1][mask];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            // 枚举所有状态
            for (int state = 0; state < mask; state++) {
                // 枚举位置 i（最后一位）选的数值是 k
                for (int k = 1; k <= n; k++) {
                    if (((state >> (k - 1)) & 1) == 0) {
                        continue;
                    }
                    // 数值 k 和位置 i 之间满足任一整除关系
                    if (k % i != 0 && i % k != 0) {
                        continue;
                    }
                    // ~ 逐位取反
                    f[i][state] += f[i - 1][state & (~(1 << (k - 1)))];
                }
            }
        }
        return f[n][mask - 1];
    }

    public static void main(String[] args) {
        CountArrangementSolution solution = new CountArrangementSolution();
        solution.countArrangement(2);
    }
}
