package com.wrongme.topic_backtracking;

/**
 * 1219. 黄金矿工
 */
public class BackTracking_1219 {
    int g[][];
    boolean visit[][];
    int m;
    int n;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int getMaximumGold(int[][] grid) {
        g = grid;
        m = grid.length;
        n = grid[0].length;
        visit = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] !=0) {
                    visit[i][j] = true;
                    ans = Math.max(ans, dfs(i, j));
                    visit[i][j] = false;
                }
            }
        }
        return ans;
    }

    private int dfs(int x, int y) {
        int ans = g[x][y];
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            // 不能超出边界
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }
            // 不得开采（进入）黄金数目为 0 的单元格
            if (g[nx][ny] == 0) {
                continue;
            }
            if (visit[nx][ny]){
                continue;
            }
            visit[nx][ny] = true;
            ans = Math.max(ans,g[x][y] + dfs(nx, ny));
            visit[nx][ny] = false;
        }
        return ans;
    }

    public static void main(String[] args) {
        BackTracking_1219 backTracking_1219 = new BackTracking_1219();
        System.out.println(backTracking_1219.getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}));
    }

}
