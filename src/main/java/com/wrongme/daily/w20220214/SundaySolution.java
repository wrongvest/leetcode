package com.wrongme.daily.w20220214;

public class SundaySolution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int idx = 0;
        while (n - 1 > idx) {
            if (bits[idx] == 0) {
                idx++;
            } else {
                idx += 2;
            }
        }
        return idx == n - 1;
    }

    public static void main(String[] args) {
        SundaySolution solution = new SundaySolution();
        System.out.println(solution.isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(solution.isOneBitCharacter(new int[]{1,1,1, 0}));
    }
}
