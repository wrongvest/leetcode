package com.wrongme.daily.w20210907;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangsSolution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int ans = 0;
        if (n < 3) {
            return ans;
        }
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> cache = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                int distance = x * x + y * y;
                cache.put(distance, cache.getOrDefault(distance, 0) + 1);
            }
            for (int dist : cache.keySet()) {
                int cnt = cache.get(dist);
                ans += cnt * (cnt - 1);
            }
        }
        return ans;
    }
}
