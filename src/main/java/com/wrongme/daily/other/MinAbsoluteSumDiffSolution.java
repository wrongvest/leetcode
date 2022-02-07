package com.wrongme.daily.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1818. 绝对差值和
 */
public class MinAbsoluteSumDiffSolution {
    int mod = (int) 1e9 + 7;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        long max = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int a = nums1[i];
            int b = nums2[i];
            int x = Math.abs(a - b);
            sum += x;
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = left + right + left >> 1;
                if (sorted[mid]<=b){
                    left = mid;
                }else {
                    right = mid-1;
                }
            }
            int nd = Math.abs(sorted[right]-b);
            if (right + 1 < n) nd = Math.min(nd, Math.abs(sorted[right + 1] - b));
            if (nd < x) max = Math.max(max, x - nd);

        }
        return (int)((sum - max) % mod);
    }

    public int minAbsoluteSumDiff2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] absResult = new int[n];
        int maxSubVal = 0;
        int index = 0;
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            absResult[i] = Math.abs(nums1[i] - nums2[i]);
            if (maxSubVal < absResult[i]) {
                maxSubVal = absResult[i];
                index = i;
            }
            set.add(nums1[i]);
            sum += absResult[i];
        }
        if (sum == 0) {
            return 0;
        }
        sum = sum - maxSubVal;
        int n2 = nums2[index];
        int min = Integer.MAX_VALUE;
        for (Integer n1 : set) {
            int temp = Math.abs(n2 - n1);
            if (temp < min) {
                min = temp;
            }
        }
        return (int) ((sum + min) % mod);
//        List<Integer> list = new ArrayList<>(set);
//        Collections.sort(list);
//        sum = sum -maxSubVal;
//        int n2 = nums2[index];
//        int left = list.get(0);
//        int right = list.get(list.size()-1);

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 5};
        int[] nums2 = {2, 3, 5};
        MinAbsoluteSumDiffSolution solution = new MinAbsoluteSumDiffSolution();
        System.out.println(solution.minAbsoluteSumDiff(nums1, nums2));
    }
}
