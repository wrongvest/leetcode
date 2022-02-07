package com.wrongme.daily.other;

import java.util.HashSet;
import java.util.Set;

public class CheckSubarraySumSolution {


    public boolean checkSubarraySum2(int[] nums, int k) {
        // 双指针
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = 0;
                for (int m = i; m <= j; m++) {
                    sum = sum + nums[m];
                }
                if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        // 前缀和
        int[] sums = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i-1];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <=nums.length; i++) {
            set.add(sums[i - 2] % k);
            if (set.contains(sums[i] % k)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{23,2,4,6,7};
        int[] nums = new int[]{23, 2, 6, 4, 7};
        CheckSubarraySumSolution solution = new CheckSubarraySumSolution();
//        System.out.println(solution.checkSubarraySum(nums,6));
        System.out.println(solution.checkSubarraySum(nums, 13));
    }
}
