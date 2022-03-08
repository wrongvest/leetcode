package com.wrongme.daily.w20220308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2055. 蜡烛之间的盘子
 */
public class ThuesDay {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] ans = new int[queries.length];
        int[] sum = new int[n + 1];
        char[] cs = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '|') {
                list.add(i);
            }
            sum[i + 1] = sum[i] + (cs[i] == '*' ? 1 : 0);
        }
        if (list.size() == 0) {
            return ans;
        }
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int left = 0;
            int right = list.size() - 1;

            // 找到 a 右边最近的蜡烛
            while (left < right) {
                int mid = left + right >> 1;
                if (list.get(mid) >= a) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int c = -1;
            if (list.get(right) >= a) {
                c = list.get(right);
            } else {
                continue;
            }
            while (left < right) {
                int mid = left + right + 1 >> 1;
                if (list.get(mid) <= b) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            int d = -1;
            if (list.get(right) <= b) {
                d = list.get(right);
            } else {
                continue;
            }
            if (c <= d) {
                ans[i] = sum[d + 1] - sum[c];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ThuesDay solution = new ThuesDay();
        Arrays.stream(solution.platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}})).forEach(x -> System.out.println(x));

    }
}
