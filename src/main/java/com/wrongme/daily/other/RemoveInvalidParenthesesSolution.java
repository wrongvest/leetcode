package com.wrongme.daily.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 301. 删除无效的括号
 */
public class RemoveInvalidParenthesesSolution {
    String s;
    int n, max, len;
    Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String _s) {
        s = _s;
        n = s.length();
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                r++;
            }
        }
        max = Math.max(l, r);
        dfs(0, "", 0);
        return new ArrayList<>(set);
    }

    private void dfs(int u, String cur, int score) {
        if (score < 0 || score > max) {
            return;
        }
        if (u == n) {
            if (score ==0 && cur.length()>=len){
                if (cur.length() > len) set.clear();
                len = cur.length();
                set.add(cur);
            }
            return ;
        }
        char c = s.charAt(u);
        if (c == '(') {
            dfs(u + 1, cur + String.valueOf(c), score + 1);
            dfs(u + 1, cur, score);
        } else if (c == ')') {
            dfs(u + 1, cur + String.valueOf(c), score - 1);
            dfs(u + 1, cur, score);
        } else {
            dfs(u + 1, cur + String.valueOf(c), score);
        }
    }
}
