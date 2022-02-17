package com.wrongme.daily.w20220214;

/**
 * 688. 骑士在棋盘上的概率
 */
public class Thursday {
    private static final int[][] DIRS = {{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {1, -2}, {-2, 1}, {-1, -2}, {-2, -1}};

    /**
     * @param n      n x n 的棋盘
     * @param k      一定次数
     * @param row    开始位置 row
     * @param column 开始位置 column
     * @return
     */
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] memo = new double[n][n][k + 1];
        return dfs(n, k, row, column, memo);
    }

    private double dfs(int n, int k, int row, int column, double[][][] memo) {
        // 走出边界了，这条路不通，概率为0
        if (row < 0 || column < 0 || row >= n || column >= n) {
            return 0;
        }
        // k 步走完了还没超出边界，这一步的概率是1，还需要乘上前面的 k 个 1/8
        if (k == 0) {
            return 1;
        }
        if (memo[row][column][k]!=0){
            return memo[row][column][k];
        }
        double ans = 0;
        // 往所有方向 都是 1/8
        for (int[] dir : DIRS) {
            ans += dfs(n, k - 1, row + dir[0], column + dir[1], memo) * (1 / 8.0);
        }
        memo[row][column][k] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Thursday thursday = new Thursday();
        System.out.println(thursday.knightProbability(3, 2, 0, 0));
    }
}
