package com.wrongme.daily;

public class LongestPalindromeSubseqSolution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        char[] cs = s.toCharArray();
        for (int len = 1; len <= n; len++) {
            for (int l = 0; l + len-1 < n; l++) {
                int r = l + len - 1;
                if (len==1){
                    f[l][r] = 1;
                }else if (len==2){
                    f[l][r] = cs[l] == cs[r]?2:1;
                }else {
                    f[l][r] = Math.max(f[l + 1][r], f[l][r - 1]);
                    f[l][r] = Math.max(f[l][r], f[l + 1][r - 1]+ (cs[l] == cs[r] ? 2 : 0));
                }
            }
        }
        return f[0][n-1];
    }
}
