package com.wrongme.daily.w20211112;

import java.util.Arrays;

/**
 * 423从英文中重建数字
 */
public class OriginalDigitsSolution {
    // 0, 8, 6, 3, 2, 7, 5, 9, 4, 1
    static String[] ss = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static int[] priority = new int[]{0, 8, 6, 3, 2, 7, 5, 9, 4, 1};

    public String originalDigits(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            int k = s.charAt(i) - 'a';
            cnt[k]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : priority) {
            int k = Integer.MAX_VALUE;
            for (char c : ss[i].toCharArray()) {
                k = Math.min(k, cnt[c - 'a']);
            }
            for (char c : ss[i].toCharArray()) {
                cnt[c - 'a'] = cnt[c - 'a'] - k;
            }
            while (k-->0){
                sb.append(i);
            }
        }
        char[] chars = sb.toString().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
