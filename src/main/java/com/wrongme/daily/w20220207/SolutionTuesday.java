package com.wrongme.daily.w20220207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1001. 网格照明
 */
public class SolutionTuesday {
    int[][] dirs = new int[][]{{0, 0}, {0, -1}, {0, 1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 0}, {1, -1}, {1, 1}};

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        long N = n;
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Set<Long> set = new HashSet<>();
        for (int[] lamp : lamps) {
            int x = lamp[0];
            int y = lamp[1];
            int a = x + y;
            int b = x - y;
            if (set.contains(x * N + y)) {
                continue;
            }
            increment(row, x);
            increment(col, y);
            increment(left, a);
            increment(right, b);
            set.add(x * N + y);
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int[] q = queries[i];
            int x = q[0];
            int y = q[1];
            int a = x + y;
            int b = x - y;
            if (row.containsKey(x) || col.containsKey(y) || left.containsKey(a) || right.containsKey(b)) {
                ans[i] = 1;
            }
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                int na = nx + ny;
                int nb = nx - ny;
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (set.contains(nx * N + ny)) {
                    set.remove(nx * N + ny);
                    decrement(row, nx);
                    decrement(col, ny);
                    decrement(left, na);
                    decrement(right, nb);
                }
            }
        }
        return ans;
    }

    private void decrement(Map<Integer, Integer> map, int key) {
        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
    }

    private void increment(Map<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public static void main(String[] args) {
    }
}
