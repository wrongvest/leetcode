package com.wrongme.daily.w20210824;

public class SumOddLengthSubarraysSolution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] sum = new int[n+1];
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + arr[i];
        }
        int ans = 0;
        for (int length = 1; length <= n; length+=2) {
            for (int i = 0; i < n; i++) {
                if (i+length<=n) {
                    ans += sum[i + length] - sum[i];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SumOddLengthSubarraysSolution solution = new SumOddLengthSubarraysSolution();
        System.out.println(solution.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
        System.out.println(solution.sumOddLengthSubarrays(new int[]{10,11,12}));
    }
}
