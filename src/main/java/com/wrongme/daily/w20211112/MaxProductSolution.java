package com.wrongme.daily.w20211112;

/**
 * 318. 最大单词长度乘积
 */
public class MaxProductSolution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] ws = new int[n];
        int idx = 0;
        for (String word : words) {
            int t = 0;
            for (int i = 0; i < word.length(); i++) {
                int u = word.charAt(i) - 'a';
                t |= (1 << u);
            }
            ws[idx++] = t;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((ws[i] & ws[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}
