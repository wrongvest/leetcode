package com.wrongme.daily.w20220207;

import java.util.ArrayList;
import java.util.List;

public class SolutionThursday {
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) {
                    ans.add(i + "/" + j);
                }
            }
        }
        return ans;
    }

    /**
     * 欧几里得算法
     *
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        SolutionThursday thursday =new SolutionThursday();
        System.out.println(thursday.simplifiedFractions(3));
    }
}
