package com.wrongme.topic_backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 38. 字符串的排列
 */
public class BackTrackingSwordOffer38 {
    boolean visit[];

    public String[] permutation(String s) {
        visit = new boolean[s.length()];
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            visit[i]=true;
            sb.append(s.charAt(i));
            dfs(s, set, sb,  1);
            sb.deleteCharAt(sb.length() - 1);
            visit[i]=false;
        }

        String[] ans = new String[set.size()];
        int index = 0;
        for (String str : set) {
            ans[index++] = str;
        }
        return ans;
    }

    private void dfs(String s, Set<String> set, StringBuilder sb, int num) {
        if (num == s.length()) {
            set.add(sb.toString());
            return;
        }
        for (int j = 0; j < s.length(); j++) {
            if (visit[j]) {
                continue;
            }
            visit[j]=true;
            sb.append(s.charAt(j));
            dfs(s, set, sb, num + 1);
            sb.deleteCharAt(sb.length() - 1);
            visit[j]=false;
        }

    }

    public static void main(String[] args) {
        BackTrackingSwordOffer38 swordOffer38 = new BackTrackingSwordOffer38();
        Arrays.stream(swordOffer38.permutation("abc")).forEach(System.out::println);
    }
}
