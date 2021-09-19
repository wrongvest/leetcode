package com.wrongme.daily.w20210907;

import java.util.List;

public class FindLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {

        dictionary.sort((a, b) -> {
            // 长度不同的字符串，按照字符串长度排倒序
            if (a.length() != b.length()) {
                // 长度相同的，则按照字典序排升序
                return b.length() - a.length();
            }
            return a.compareTo(b);
        });
        int n = s.length();
        for (String ss : dictionary) {
            int m = ss.length();
            int i = 0;
            int j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) == ss.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == m) {
                return ss;
            }
        }
        return "";
    }
}
