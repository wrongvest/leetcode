package com.wrongme.daily;

import java.util.ArrayList;
import java.util.List;

public class PathInZigZagTreeSolution {

    public List<Integer> pathInZigZagTree(int label) {
        int level = 1;
        while (getEnd(level) < label) {
            level++;
        }
        int[] ans = new int[level];
        int idx = level - 1, cur = label;
        while (idx >= 0) {
            ans[idx--] = cur;
            int tot = (int) Math.pow(2, level - 1);
            int start = getStart(level);
            int end = getEnd(level);
            if (level % 2 == 0) {
                // 偶数层
                int j = tot / 2;
                for (int i = start; i <= end; i += 2, j--) {
                    if (i == cur || i + 1 == cur) {
                        break;
                    }
                }
                int prevStart = getStart(level - 1);
                while (j-- > 1) {
                    prevStart++;
                }
                cur = prevStart;

            } else {
                // 奇数层
                int j = 1;
                for (int i = start; i <= end; i += 2, j++) {
                    if (i == cur || i + 1 == cur) {
                        break;
                    }
                }
                int preEnd = getEnd(level - 1);
                while (j-- > 1) {
                    preEnd--;
                }
                cur = preEnd;
            }
            level--;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : ans) list.add(i);
        return list;

    }

    int getStart(int level) {
        return (int) Math.pow(2, level - 1);
    }

    int getEnd(int level) {
        int a = getStart(level);
        return a + a - 1;
    }

}
