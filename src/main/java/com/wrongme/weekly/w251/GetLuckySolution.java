package com.wrongme.weekly.w251;

public class GetLuckySolution {
    public int getLucky(String s, int k) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int v = c - 'a' + 1;
            String vStr = v + "";
            for (int j = 0; j < vStr.length(); j++) {
                sum += (vStr.charAt(j)-'0');
            }
        }
        if (k == 1) {
            return sum;
        }
        int ans = 0;
        for (int i = 2; i <= k; i++) {
            String str = Integer.toString(sum);
            for (int j = 0; j < str.length(); j++) {
                ans = ans + (str.charAt(j)-'0');
            }
            if (i <= k - 1) {
                sum = ans;
                ans = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GetLuckySolution solution = new GetLuckySolution();
        System.out.println(solution.getLucky("iiii", 1));
        System.out.println(solution.getLucky("leetcode", 2));
        System.out.println(solution.getLucky("zbax", 2));
    }
}
