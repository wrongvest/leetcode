package com.wrongme.daily.w20211112;

public class MaxPowerSolution {

    public int maxPower(String s) {
        int max = 1;
        int count = 1;
        char pre = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == pre) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count =1;
            }
            pre = ch;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxPowerSolution solution = new MaxPowerSolution();
        System.out.println(solution.maxPower("tourist"));
        System.out.println(solution.maxPower("leetcode"));
        System.out.println(solution.maxPower("abbcccddddeeeeedcba"));
        System.out.println(solution.maxPower("triplepillooooow"));
        System.out.println(solution.maxPower("hooraaaaaaaaaaay"));
    }
}
