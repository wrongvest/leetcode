package com.wrongme.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 909. 蛇梯棋
 */
public class SnakesAndLaddersSolution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        // 初始时将起点状态 (1,0) 加入队列
        // 表示当前位于起点 1，移动次数为 0。
        queue.offer(new int[]{1, 0});
        // 不断取出队首，每次取出队首元素时扩展新状态，即遍历该节点的出边，
        // 若出边对应节点未被访问，则将该节点和移动次数加一的结果作为新状态，加入队列
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            // 只能在[1,6] 之间
            for (int i = 1; i <= 6; i++) {
                // 挪i步
                int next = p[0] + i;
                // 超出边界
                if (next > n * n) {
                    break;
                }
                // 得到下一步的行列
                int[] rc = id2RowColumn(next, n);
                // 存在蛇或者梯子
                if (board[rc[0]][rc[1]] > 0) {
                    // 传送到 指定编号
                    next = board[rc[0]][rc[1]];
                }
                // 到达终点
                if (next == n * n) {
                    return p[1] + 1;
                }
                // 如果当前编号没有访问过
                if (!vis[next]) {
                    // 标记当前编号已经访问过
                    vis[next] = true;
                    // 扩展新状态
                    queue.offer(new int[]{next, p[1] + 1});
                }
            }
        }
        return -1;
    }

    /**
     * 编号 转成 坐标（行列）
     *
     * @param id 编号
     * @param n  N*N
     * @return
     */
    private int[] id2RowColumn(int id, int n) {
        int row = (id - 1) / n;
        int col = (id - 1) % n;
        if (row % 2 == 1) {
            col = n - 1 - col;
        }
        return new int[]{n - 1 - row, col};
    }

    public static void main(String[] args) {
//        SnakesAndLaddersSolution solution = new SnakesAndLaddersSolution();
//        solution
        int[] temp = new int[]{1, 0};
        System.out.println(temp[0]);
        System.out.println(temp[0] + 1);
    }
}
