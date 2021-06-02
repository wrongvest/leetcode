package com.wrongme.daily;

public class CheckSubarraySumSolution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // 双指针
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
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

    public static void main(String[] args) {
//        int[] nums = new int[]{23,2,4,6,7};
        int[] nums = new int[]{23,2,6,4,7};
        CheckSubarraySumSolution solution = new CheckSubarraySumSolution();
//        System.out.println(solution.checkSubarraySum(nums,6));
        System.out.println(solution.checkSubarraySum(nums,13));
    }
}
