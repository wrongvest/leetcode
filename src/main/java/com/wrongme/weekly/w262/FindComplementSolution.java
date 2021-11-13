package com.wrongme.weekly.w262;

public class FindComplementSolution {
    public int findComplement(int num) {
        int s = -1;
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) != 0) {
                s = i;
                break;
            }
        }
        int ans = 0;
        for (int i = 0; i < s; i++) {
            if (((num >> i) & 1) == 0) ans |= (1 << i);
        }
        return ans;
    }

    public static void main(String[] args) {
        FindComplementSolution solution = new FindComplementSolution();
        System.out.println(solution.findComplement(10));
    }
}
