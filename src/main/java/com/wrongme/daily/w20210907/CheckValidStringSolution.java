package com.wrongme.daily.w20210907;

public class CheckValidStringSolution {
    public boolean checkValidString(String s) {
        if (s.length() == 0) {
            return true;
        }
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                l++;
                r++;
            } else if (ch == ')') {
                l--;
                r--;
            } else {
                l--;
                r++;
            }
            l = Math.max(l, 0);
            if (l > r) {
                return false;
            }
        }
        return l == 0;
    }

    public static void main(String[] args) {
        CheckValidStringSolution solution = new CheckValidStringSolution();
        System.out.println(solution.checkValidString("()"));
        System.out.println(solution.checkValidString("((*)"));
        System.out.println(solution.checkValidString("(*))"));
        System.out.println(solution.checkValidString("(*)))"));
    }
}
