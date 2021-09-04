package com.wrongme.daily.w20210831;

import java.util.Arrays;

/**
 * 面试题 17.14. 最小K个数
 */
public class SmallestKSolution {
    public int[] smallestK(int[] arr, int k) {
        int[] ans = new int[k];
        if (k == 0) {
            return ans;
        }
        Arrays.sort(arr);
        System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }

    public static void main(String[] args) {
        SmallestKSolution solution = new SmallestKSolution();
        echo(solution.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4));
    }

    static void echo(int[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
    }
}
