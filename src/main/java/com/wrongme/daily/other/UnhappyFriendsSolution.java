package com.wrongme.daily.other;

import java.util.HashMap;
import java.util.Map;

public class UnhappyFriendsSolution {
    // {x : {y : score1}, {z : score12}, ... }
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        for (int i = 0; i < n; i++) {
            int[] preference = preferences[i];
            Map<Integer, Integer> cur = new HashMap<>();
            for (int j = 0; j < n - 1; j++) {
                cur.put(preference[j], n - j);
            }
            map.put(i, cur);
        }
        int ans = 0;
        int m = pairs.length;
        for (int i = 0; i < m; i++) {
            int x = pairs[i][0], y = pairs[i][1];
            boolean xok = false, yok = false;
            for (int j = 0; j < m; j++) {
                if (i==j){
                    continue;
                }
                int u = pairs[j][0], v = pairs[j][1];
                if (!xok&&check(x,y,u,v)){
                    xok =true;
                }
                if (!yok&&check(y,x,u,v)){
                    yok =true;
                }
                if (xok&&yok){
                    break;
                }
            }
            if (xok){
                ans++;
            }
            if (yok){
                ans++;
            }
        }
        return ans;
    }

    boolean check(int x, int y, int u, int v) {
        Map<Integer, Integer> xMap = map.get(x);
        Map<Integer, Integer> yMap = map.get(y);
        Map<Integer, Integer> uMap = map.get(u);
        Map<Integer, Integer> vMap = map.get(v);
        if (xMap.get(u) > xMap.get(y) && uMap.get(x) > uMap.get(v)) {
            return true;
        }
        if (xMap.get(v) > xMap.get(y) && vMap.get(x) > vMap.get(u)) {
            return true;
        }
        return false;
    }
}
