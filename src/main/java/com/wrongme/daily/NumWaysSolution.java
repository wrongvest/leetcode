package com.wrongme.daily;

import java.util.*;

public class NumWaysSolution {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    int n, ans;

    public int numWays1(int n, int[][] relation, int k) {
        this.n = n;
        for (int[] rela : relation) {
            int a = rela[0], b = rela[1];
            Set<Integer> set = map.getOrDefault(a, new HashSet<>());
            set.add(b);
            map.put(a, set);
        }
        dfs(0, k);
        return ans;
    }

    private void dfs(int u, int k) {
        if (k == 0) {
            if (u == this.n - 1) {
                ans++;
            }
            return;
        }
        Set<Integer> set = map.get(u);
        if (set == null) {
            return;
        }
        for (Integer next : set) {
            dfs(next, k - 1);
        }
    }

    public int numWays(int n, int[][] relation, int k) {
        for (int[] rela : relation) {
            int a = rela[0], b = rela[1];
            Set<Integer> set = map.getOrDefault(a, new HashSet<>());
            set.add(b);
            map.put(a, set);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        // k ==0 的时候 只剩下k次入队的元素，只需要判断 队列中 等于n-1的数出现的次数
        while (!deque.isEmpty() && k-- > 0) {
            int size = deque.size();
            // size 只初始化一次
            while (size-- > 0) {
                Integer first = deque.pollFirst();
                Set<Integer> set = map.get(first);
                if (set == null) {
                    continue;
                }
                set.forEach(deque::addLast);
            }
        }
        int ans = 0;
        while (!deque.isEmpty()) {
            if (deque.pollFirst() == n - 1) {
                ans++;
            }
        }
        return ans;
    }
}
