package com.wrongme.daily.w20211112;

/**
 * 677. 键值映射
 */
public class MapSum {
    int N = 2510;
    int[][] tries = new int[N][26];
    int hash[] = new int[N];
    int idx = 0;

    public MapSum() {

    }

    public void insert(String key, int val) {
        int p = 0;
        for (int i = 0; i < key.length(); i++) {
            int u = key.charAt(i) - 'a';
            if (tries[p][u] == 0) {
                idx = idx+1;
                tries[p][u] = idx;
            }
            p = tries[p][u];
        }
        hash[p] = val;
    }

    public int sum(String prefix) {
        int p = 0;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (tries[p][u] == 0) {
                return 0;
            }
            p = tries[p][u];
        }
        return dfs(p);
    }

    private int dfs(int p) {
        int ans = hash[p];
        for (int u = 0; u < 26; u++) {
            if (tries[p][u] != 0) {
                ans += dfs(tries[p][u]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple",3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("ap",2);
        System.out.println(mapSum.sum("ap"));
    }
}
