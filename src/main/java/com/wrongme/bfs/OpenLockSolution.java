package com.wrongme.bfs;

import java.util.*;

public class OpenLockSolution {
    String s;
    String e;
    Set<String> set = new HashSet<>();

    public int openLock(String[] deadends, String target) {
        s = "0000";
        e = target;
        if (s.equals(e)) return 0;
        set.addAll(Arrays.asList(deadends));
        if (set.contains(s) || set.contains(target)) {
            return -1;
        }
        return bfs();
    }

    private int bfs() {
        // 从头开始搜索
        Deque<String> d1 = new ArrayDeque<>();
        // 从尾部开始搜索
        Deque<String> d2 = new ArrayDeque<>();

        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        d1.add(s);
        d2.add(e);
        m1.put(s, 0);
        m2.put(e, 0);

        while (!d1.isEmpty() && !d2.isEmpty()) {
            int t;
            if (d1.size() <= d2.size()) {
                t = update(d1, m1, m2);
            } else {
                t = update(d2, m2, m1);
            }
            if (t != -1) {
                return t;
            }
        }

        return -1;
    }

    private int update(Deque<String> deque, Map<String, Integer> cur, Map<String, Integer> other) {
        String w = deque.pollFirst();
        // 变换其中任意一个拔轮
        for (int i = 0; i < 4; i++) {
            // [-1,1]
            // 对于任意一个拔轮只能加1或者减1
            for (int j = -1; j <= 1; j++) {
                if (j == 0) {
                    continue;
                }
                // 拔轮+1 在1-9 之间时 直接取
                // 拔轮+1 ==10 取数字0
                char c = w.charAt(i);
                int charNum = c - '0';
                int next = (charNum + j) % 10;
                if (next == -1) {
                    next = 9;
                }
                Integer wChangeCount = cur.get(w);

                String sub = w.substring(0, i) + next + w.substring(i + 1);
                // 不在死锁范围
                if (!set.contains(sub)) {
                    // 没有转到过
                    if (cur.get(sub) == null) {
                        System.out.println(sub);
                        // 存在于反向搜索的结果中
                        if (other.containsKey(sub)) {
                            return wChangeCount + 1 + other.get(sub);
                        }
                        deque.addLast(sub);
                        cur.put(sub, wChangeCount + 1);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        OpenLockSolution solution = new OpenLockSolution();
        System.out.println(solution.openLock(deadends, "0202"));
    }
}
