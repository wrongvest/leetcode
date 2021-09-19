package com.wrongme.daily.w20210907;

public class BalancedStringSplitSolution {
    public int balancedStringSplit(String s) {
        int ans = 0;
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                l++;
            }
            if (c == 'R') {
                r++;
            }
            if (r > 0 && l == r) {
                ans++;
                l = r = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        BalancedStringSplitSolution solution = new BalancedStringSplitSolution();
        System.out.println(solution.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(solution.balancedStringSplit("RLLLLRRRLR"));
        System.out.println(solution.balancedStringSplit("LLLLRRRR"));
        System.out.println(solution.balancedStringSplit("RLRRRLLRLL"));
    }
}
