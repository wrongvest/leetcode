package com.wrongme.daily.W20220221;

/**
 * 1706. 球会落何处
 */
public class Thursday {
    /**
     * r 和 c 表示小球当前所处的位置，受重力影响，在不被卡住的情况下，r 会持续自增，直到到达底部，而 c 的变化，则是取决于当前挡板 grid[r][c] 的方向，
     * 若 grid[r][c] 为 1，则小球的下一个位置为 (r+1,c+1)；
     * 若 grid[r][c] 为 -1，则下一位置为 (r + 1, c - 1)，即可以统一表示为 (r + 1, c + grid[r][c])。
     * 当且仅当小球在本次移动过程中没被卡住，才能继续移动。
     * 即只有 c + grid[r][c]c+grid[r][c] 没有超过矩阵的左右边界（没有被边界卡住），
     * 或者 grid[r][c]和 grid[r][c + grid[r][c]] 同向（不形成夹角），小球方能继续移动。
     *
     * @param grid
     * @return
     */

    int m, n;
    int[][] g;

    public int[] findBall(int[][] grid) {
        g = grid;
        m = g.length;
        n = g[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = getVal(i);
        }
        return ans;
    }

    private int getVal(int x) {
        int r = 0;
        int c = x;
        while (r < m) {
            int ne = c + g[r][c];
            if (ne < 0 || ne >= n) {
                return -1;
            }
            if (g[r][c] != g[r][ne]) {
                return -1;
            }
            r++;
            c = ne;
        }
        return c;
    }

    public static void main(String[] args) {

    }
}
